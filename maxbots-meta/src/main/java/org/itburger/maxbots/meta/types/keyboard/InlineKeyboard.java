package org.itburger.maxbots.meta.types.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineKeyboard {

    @JsonProperty("buttons")
    private List<List<Button>> buttons;

    public static InlineKeyboard of(List<List<Button>> buttons) {
        return new InlineKeyboard(buttons);
    }


}
