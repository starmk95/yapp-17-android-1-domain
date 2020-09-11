package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostTest {

    private Posts posts;
    private Post post;


    @BeforeEach
    @DisplayName("회원은 특정 위치를 선택해 게시글을 생성할 수 있다." +
            "좌표값(위도, 경도), 글내용, 생성된 시점을 정보로 가진다." +
            "한 게시글에 여러 개의 사진을 달 수 있다." +
            "한 게시글에 색상을 하나 지정할 수 있다.")
    void createPostTest() {

        post = Post.builder()
                .coodinate(new Coodinate(37.511123, 127.0869332))
                .address("서울시 송파구")
                .city("서울")
                .postBody("글 내용 적기")
                .color(new Color("감정", Color.Colors.RED))
                .postImage(new PostImage("사진 1"))
                .postImage(new PostImage("사진 2"))
                .postImage(new PostImage("사진 3"))
                .build();

        posts = new Posts();
        posts.addPost(post);
//        assertNotNull(posts);

//        assertNotNull(post);
        System.out.println(post.toString());
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
        String expectedAns = "사진 1\n사진 2\n사진 3\n";

        System.out.println(urls);
        assertThat(urls).isEqualTo(expectedAns);

    }


}