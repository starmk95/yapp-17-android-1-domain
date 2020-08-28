package domain;

public class Emotion {

    private String emotion;
    private EmotionColor emotionColor;

    public Emotion(String emotion, EmotionColor emotionColor) {
        this.emotion = emotion;
        this.emotionColor = emotionColor;
    }

    public String getEmotion() {
        return emotion;
    }

    public EmotionColor getEmotionColor() {
        return emotionColor;
    }
}
