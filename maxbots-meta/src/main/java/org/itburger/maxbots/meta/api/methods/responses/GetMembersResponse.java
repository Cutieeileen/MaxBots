package org.itburger.maxbots.meta.api.methods.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.types.ChatMember;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMembersResponse {

    @JsonProperty("members")
    private List<ChatMember> members;

    @JsonProperty("marker")
    private Long marker;
}
