package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Color {
    public enum Colors {
        RED, ORANGE, YELLOW, GREEN, BLUE
    }
    private String emotion;
    private Colors emotionColor;

}
