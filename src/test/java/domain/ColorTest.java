package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColorTest {

    @DisplayName("Color 객체 생성")
    @Test
    void createColorTest(){
        Color redColor = new Color("감정1", Color.Colors.RED);
        Color orangeColor = new Color("감정2", Color.Colors.ORANGE);
        Color yellowColor = new Color("감정3", Color.Colors.YELLOW);
        Color greenColor = new Color("감정4", Color.Colors.GREEN);
        Color blueColor = new Color("감정5", Color.Colors.BLUE);

        //

        System.out.println(redColor.getEmotion());
        System.out.println(redColor.getEmotionColor());
    }
}
