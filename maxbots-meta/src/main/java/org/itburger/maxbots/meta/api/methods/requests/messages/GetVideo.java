package org.itburger.maxbots.meta.api.methods.requests.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetVideo extends BotApiMethod<GetVideo.VideoInfo> {

    private String videoToken;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/videos/" + videoToken;
    }

    @Override
    public Class<VideoInfo> getResponseClass() {
        return VideoInfo.class;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VideoInfo {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("token")
        private String token;
        @JsonProperty("url")
        private String url;
        @JsonProperty("thumbnail")
        private String thumbnail;
        @JsonProperty("duration")
        private Integer duration;
        @JsonProperty("width")
        private Integer width;
        @JsonProperty("height")
        private Integer height;
    }
}
