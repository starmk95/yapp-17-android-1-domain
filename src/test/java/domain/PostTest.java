package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostTest {

    private User user;
    private Post post;


    @BeforeEach
    @DisplayName("게시글을 생성할 수 있다. + 감정은 사용자가 추가할 수 있다.")
    void createPostTest() {

        // 사용자, 감정 생성
        user = new User("김민규");
        user.addEmotion("Happy", EmotionColor.YELLOW);
        user.addEmotion("Sad", EmotionColor.BLUE);

        // 감정 선택
        Emotion happy = user.getEmotionList().get(0);

        // 게시글 작성
        post = new Post("서울시 송파구", "첫번째 게시물", "서울", happy);

        ArrayList<PostImage> images = new ArrayList<>();
        images.add(new PostImage("url1"));
        images.add(new PostImage("url2"));
        images.add(new PostImage("url3"));
        post.addImages(images);
    }

    @Test
    @DisplayName("게시글에 여러 개의 사진을 달 수 있다.")
    void addMultipleImagesTest() {
        ArrayList<PostImage> images = new ArrayList<>();
        images.add(new PostImage("url1"));
        images.add(new PostImage("url2"));
        images.add(new PostImage("url3"));
        post.addImages(images);


    }

    @Test
    @DisplayName("글의 정보를 각각 조회할 수 있다.")
    void queryPostTest() {

        Post newPost =  post.queryPost();

        assertThat(newPost.toString()).isEqualTo(post.toString());

    }

    @Test
    @DisplayName("글의 사진 상세 보기")
    void showDetailsTest() {
        String urls = post.getImageDetails();
        String expectedAns = "url1\nurl2\nurl3\n";

        System.out.println(urls);
        assertThat(urls).isEqualTo(expectedAns);

    }


}