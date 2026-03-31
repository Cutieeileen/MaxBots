package org.itburger.maxbots.meta.api.methods.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.BotInfo;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditMe extends BotApiMethod<BotInfo> {

    private String name;
    private String description;
    private List<BotCommandUpdate> commands;

    @Override
    public String getHttpMethod() {
        return "PATCH";
    }

    @Override
    public String getEndpoint() {
        return "/me";
    }

    @Override
    public Class<BotInfo> getResponseClass() {
        return BotInfo.class;
    }

    @Override
    public Object getBody() {
        return this;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BotCommandUpdate {
        @JsonProperty("name")
        private String name;
        @JsonProperty("description")
        private String description;
    }
}
