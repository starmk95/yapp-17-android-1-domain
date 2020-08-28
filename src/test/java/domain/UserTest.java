package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("김민규");

        user.addEmotion("Happy", EmotionColor.YELLOW);
        user.addEmotion("Sad", EmotionColor.BLUE);
        user.addEmotion("Peaceful", EmotionColor.GREEN);
        user.addEmotion("Hyped", EmotionColor.RED);
        user.addEmotion("Exhausted", EmotionColor.ORGANE);
    }

    @Test
    @DisplayName("사용자 생성")
    void createUserTest() {
        user = new User("김민규");

        assertNotNull(user);
    }

    @Test
    @DisplayName("감정은 사용자가 추가할 수 있다.")
    void createEmotionTest() {
        user.addEmotion("Happy", EmotionColor.YELLOW);
        user.addEmotion("Sad", EmotionColor.BLUE);
        user.addEmotion("Peaceful", EmotionColor.GREEN);
        user.addEmotion("Hyped", EmotionColor.RED);
        user.addEmotion("Exhausted", EmotionColor.ORGANE);

        // 중복 감정 불허 확인용
        user.addEmotion("Peaceful", EmotionColor.RED);

        System.out.println(user.getmEmotions());

        for (Emotion emotion : user.getEmotionList()) {
            System.out.println(emotion.getEmotion()
                    + " - " + emotion.getEmotionColor());
        }
    }

    @Test
    @DisplayName("감정은 사용자가 삭제할 수 있다.")
    void deleteEmotionTest() {
        user.addEmotion("Happy", EmotionColor.YELLOW);
        user.addEmotion("Sad", EmotionColor.BLUE);
        user.addEmotion("Peaceful", EmotionColor.GREEN);

        System.out.println(user.getmEmotions());

        user.deleteEmotion("Peaceful");

        user.deleteEmotion("없는 감정 이름");

        System.out.println(user.getmEmotions());

    }

    @Test
    @DisplayName("게시물 생성")
    void CreatePostInUserTest() {
        Post post = user.createPost("서울시 송파구", "1번 내용", "서울", user.getEmotionList().get(0));
        assertNotNull(post);

        System.out.println(post.toString());
    }

    @Test
    @DisplayName("게시글 전체를 조회할 수 있다.")
    void getAllPostsTest() {
        Post post1 = user.createPost("서울시 송파구", "1번 내용", "서울", user.getEmotionList().get(0));
        assertNotNull(post1);
        user.createPost("서울시 강남구", "2번 내용", "서울", user.getEmotionList().get(1));
        user.createPost("경기도 수원시 팔달구", "3번 내용", "수원", user.getEmotionList().get(2));
        user.createPost("부산시 송파구 구포동", "4번 내용", "부산", user.getEmotionList().get(3));
        user.createPost("강원도 속초시 대포동", "5번 내용", "속초", user.getEmotionList().get(4));

        ArrayList<Post> allPosts =  user.getAllPosts();

        System.out.println("\n위는 메소드 내부적인 출력, 아래는 반환 리스트를 따로 출력한 값들");

        for (Post post : allPosts) {
            post.queryPost();
        }
    }



}
