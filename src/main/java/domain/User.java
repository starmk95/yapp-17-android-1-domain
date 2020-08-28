package domain;

import java.util.ArrayList;

public class User {
    private String userId;
    private ArrayList<Emotion> mEmotions;
    private ArrayList<Post> mPosts;

    public User(String userId) {
        this.userId = userId;
        mEmotions = new ArrayList<>();
        mPosts = new ArrayList<>();
    }

    public Post createPost(String address, String postBody, String city, Emotion emotion) {
        Post newPost = new Post(address, postBody, city, emotion);
        mPosts.add(newPost);
        return newPost;
    }

    public void addEmotion(String emotionName, EmotionColor emotionColor) {
        for (Emotion emotion : mEmotions) {
            if (emotion.getEmotion().equals(emotionName)) {
                System.out.println("중복되는 감정입니다.");
                return;
            }
        }
        mEmotions.add(new Emotion(emotionName, emotionColor));
    }

    public String getmEmotions() {
        StringBuilder sb = new StringBuilder();
        for (Emotion emotion : mEmotions) {
            sb.append(emotion.getEmotion() + " : "
                    + emotion.getEmotionColor() + "\n");
        }
        String emotionList = sb.toString();
        return emotionList;
    }

    public void deleteEmotion(String emotionName) {
        for (Emotion emotion : mEmotions) {
            if (emotion.getEmotion().equals(emotionName)) {
                System.out.println("해당 감정을 삭제합니다.");
                mEmotions.remove(emotion);
                return;
            }
        }
        System.out.println("해당되는 감정을 찾지 못했습니다.");
    }


    public ArrayList<Emotion> getEmotionList() {
        return mEmotions;
    }

    public ArrayList<Post> getAllPosts() {
        for (Post post : mPosts) {
            System.out.println(post.toString());
        }
        return mPosts;
    }
}
