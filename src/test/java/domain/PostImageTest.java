package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostImageTest {

    @DisplayName("url 확인")
    @Test
    void createPostImageTest() {
        PostImage postImage = new PostImage("url");
        System.out.println(postImage.getUrl());
    }
}
