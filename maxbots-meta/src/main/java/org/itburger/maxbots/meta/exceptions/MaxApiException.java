package org.itburger.maxbots.meta.exceptions;

public class MaxApiException extends RuntimeException {

    private final int httpCode;
    private final String apiError;

    public MaxApiException(String message) {
        super(message);
        this.httpCode = -1;
        this.apiError = null;
    }

    public MaxApiException(int httpCode, String apiError) {
        super("MAX API error " + httpCode + ": " + apiError);
        this.httpCode = httpCode;
        this.apiError = apiError;
    }

    public MaxApiException(String message, Throwable cause) {
        super(message, cause);
        this.httpCode = -1;
        this.apiError = null;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getApiError() {
        return apiError;
    }
}
