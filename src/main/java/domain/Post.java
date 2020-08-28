package domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Post {

    private double mLat;
    private double mLong;
    private String mAddress;
    private String mPostBody;
    private String mCity;
    private String mUpdateDate;
    private Emotion mEmotion;
    private ArrayList<PostImage> mpostImages;

    public Post(String mAddress, String mPostBody, String mCity, Emotion mEmotion) {
        // 주소를 받아서 위도, 경도로 변환하여 저장
        this.mLat = 0.0;
        this.mLong = 0.0;

        this.mAddress = mAddress; // 주소 받기
        this.mPostBody = mPostBody; // 글 내용 받기
        this.mCity = mCity; // 도시 받기

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date time = new Date();
        this.mUpdateDate = simpleDateFormat.format(time); // 생성날짜 받기
        this.mEmotion = mEmotion; // 감정 받기

        this.mpostImages = new ArrayList<>();

    }

    public void addImages(ArrayList<PostImage> images) {
        for (PostImage image : images) {
            mpostImages.add(image);
        }
    }

    public Post queryPost() {
        StringBuilder sb = new StringBuilder();
        sb.append("주소 : " + mAddress + "\n");
        sb.append("글 내용 : " + mPostBody + "\n");
        sb.append("도시 : " + mCity + "\n");
        sb.append("생성 날짜 : " + mUpdateDate + "\n");
        sb.append("감정 : " + mEmotion.getEmotion() + "\n");
        if (!mpostImages.isEmpty()) {
            sb.append("사진 url : ");
            Random random = new Random();
            // 0 ~ (전체사진개수-1) 중 하나의 수가 랜덤으로 선택됨
            int randomIndex = random.nextInt(mpostImages.size());
            // 랜덤으로 정한 사진의 url 가져오기
            sb.append(mpostImages.get(randomIndex).getUrl() + "\n");
        }
        System.out.println(sb);
        return this;
    }

    public String getImageDetails() {
        if (mpostImages.isEmpty()) {
            System.out.println("등록된 사진이 없습니다.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (PostImage image : mpostImages) {
            sb.append(image.getUrl() + "\n");
        }
        String result =  sb.toString();
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "mLat=" + mLat +
                ", mLong=" + mLong +
                ", mAddress='" + mAddress + '\'' +
                ", mPostBody='" + mPostBody + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mUpdateDate='" + mUpdateDate + '\'' +
                ", mEmotion=" + mEmotion +
                ", mpostImages=" + mpostImages +
                '}';
    }

}
