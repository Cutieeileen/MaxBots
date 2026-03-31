package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    @JsonProperty("url")
    private String url;

    @JsonProperty("time")
    private Long time;

    @JsonProperty("update_types")
    private List<String> updateTypes;

    @JsonProperty("version")
    private String version;
}
