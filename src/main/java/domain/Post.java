package domain;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Builder
@Getter
@ToString
public class Post {

    private Coodinate coodinate;
    private String address;
    private String city;
    private String postBody;
    @Builder.Default
    private String updateDate
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private Color color;
    @Singular
    private List<PostImage> postImages;

    public Post queryPost() {
        StringBuilder sb = new StringBuilder();
        sb.append("주소 : " + address + "\n");
        sb.append("글 내용 : " + postBody + "\n");
        sb.append("도시 : " + city + "\n");
        sb.append("생성 날짜 : " + updateDate + "\n");
        sb.append("감정 : " + color.getEmotion() + "\n");
        sb.append("색 : " + color.getEmotionColor() + "\n");

        if (!postImages.isEmpty()) {
            sb.append("사진 url : ");
            Random random = new Random();
            // 0 ~ (전체사진개수-1) 중 하나의 수가 랜덤으로 선택됨
            int randomIndex = random.nextInt(postImages.size());
            // 랜덤으로 정한 사진의 url 가져오기
            sb.append(postImages.get(randomIndex).getUrl() + "\n");
        }
        System.out.println(sb);
        return this;
    }

    public String getImageDetails() {
        if (postImages.isEmpty()) {
            System.out.println("등록된 사진이 없습니다.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (PostImage image : postImages) {
            sb.append(image.getUrl() + "\n");
        }
        String result =  sb.toString();
        return result;
    }

    public void addPostImage(PostImage postImage) {
        postImages.add(postImage);
    }

}
