package org.itburger.maxbots.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.generics.BotApiMethodExecutor;
import org.itburger.maxbots.meta.exceptions.MaxApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class MaxClient implements BotApiMethodExecutor {

    private static final Logger log = LoggerFactory.getLogger(MaxClient.class);

    private static final MediaType JSON = MediaType.get(MaxBotApiConfig.CONTENT_TYPE_JSON);

    private final String token;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public MaxClient(String token) {
        this.token = token;
        this.httpClient = new OkHttpClient.Builder().build();
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MaxClient(String token, OkHttpClient httpClient) {
        this.token = token;
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MaxClient(String token, OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.token = token;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> T execute(BotApiMethod<T> method) throws MaxApiException {
        Request request = buildRequest(method);
        try (Response response = httpClient.newCall(request).execute()) {
            return parseResponse(response, method.getResponseClass());
        } catch (IOException e) {
            throw new MaxApiException("HTTP request failed: " + e.getMessage(), e);
        }
    }

    @Override
    public <T> CompletableFuture<T> executeAsync(BotApiMethod<T> method) {
        CompletableFuture<T> future = new CompletableFuture<>();
        Request request = buildRequest(method);
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(new MaxApiException("HTTP request failed: " + e.getMessage(), e));
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    future.complete(parseResponse(response, method.getResponseClass()));
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            }
        });
        return future;
    }

    private <T> Request buildRequest(BotApiMethod<T> method) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(MaxBotApiConfig.BASE_URL + method.getEndpoint()).newBuilder();

        Map<String, String> queryParams = method.getQueryParams();
        if (queryParams != null) {
            queryParams.forEach(urlBuilder::addQueryParameter);
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(urlBuilder.build())
                .header(MaxBotApiConfig.AUTH_HEADER, token);

        String httpMethod = method.getHttpMethod();
        switch (httpMethod) {
            case "GET" -> requestBuilder.get();
            case "DELETE" -> {
                Object body = method.getBody();
                if (body != null) {
                    requestBuilder.delete(buildRequestBody(body));
                } else {
                    requestBuilder.delete();
                }
            }
            case "POST" -> {
                Object body = method.getBody();
                RequestBody requestBody = body != null ? buildRequestBody(body) : RequestBody.create(new byte[0], JSON);
                requestBuilder.post(requestBody);
            }
            case "PUT" -> {
                Object body = method.getBody();
                RequestBody requestBody = body != null ? buildRequestBody(body) : RequestBody.create(new byte[0], JSON);
                requestBuilder.put(requestBody);
            }
            case "PATCH" -> {
                Object body = method.getBody();
                RequestBody requestBody = body != null ? buildRequestBody(body) : RequestBody.create(new byte[0], JSON);
                requestBuilder.patch(requestBody);
            }
            default -> throw new IllegalArgumentException("Unsupported HTTP method: " + httpMethod);
        }

        return requestBuilder.build();
    }

    private RequestBody buildRequestBody(Object body) {
        try {
            String json = objectMapper.writeValueAsString(body);
            log.debug("Request body: {}", json);
            return RequestBody.create(json, JSON);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize request body", e);
        }
    }

    private <T> T parseResponse(Response response, Class<T> responseClass) throws MaxApiException {
        try {
            String body = response.body() != null ? response.body().string() : "";
            log.debug("Response [{}]: {}", response.code(), body);

            if (!response.isSuccessful()) {
                throw new MaxApiException("API error [" + response.code() + "]: " + body);
            }

            if (body.isEmpty()) {
                return null;
            }

            return objectMapper.readValue(body, responseClass);
        } catch (MaxApiException e) {
            throw e;
        } catch (Exception e) {
            throw new MaxApiException("Failed to parse response: " + e.getMessage(), e);
        }
    }
}
