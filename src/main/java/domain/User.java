package domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private String user;
    private Posts posts = new Posts();
    private List<Color> colorList = new ArrayList<>();

    public void addColorEmotion(Color color) {
        for (Color x : colorList) {
            if (x.getEmotionColor() == color.getEmotionColor()) {
                System.out.println("이미 감정이 지정된 색입니다.");
                return;
            }
        }
        colorList.add(color);
    }

}
