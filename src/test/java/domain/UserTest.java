package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("사용자 생성")
    @Test
    void createUser() {
        User user1 = new User("사용자1");
        Color redColor = new Color("감정1", Color.Colors.RED);
        Color orangeColor = new Color("감정2", Color.Colors.ORANGE);
        user1.addColorEmotion(redColor);
        user1.addColorEmotion(orangeColor);

        Color dupRedColor = new Color("감정0", Color.Colors.RED);
        user1.addColorEmotion(dupRedColor);

        assertNotNull(user1);
        System.out.println(user1.getColorList());

    }
}