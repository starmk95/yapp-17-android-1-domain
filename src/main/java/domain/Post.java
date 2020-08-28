package domain;

public class Post {

    private double mLat;
    private double mLong;
    private String mAddress;
    private String mPostBody;
    private String mCity;
    private String mUpdateDate;
    private Emotion mEmotion;

    public Post(String mAddress, String mPostBody, String mCity, String mUpdateDate, Emotion mEmotion) {
        // 주소를 받아서 위도, 경도로 변환하여 저장
        this.mLat = 0.0;
        this.mLong = 0.0;

        this.mAddress = mAddress; // 주소 받기
        this.mPostBody = mPostBody; // 글 내용 받기
        this.mCity = mCity; // 도시 받기
        this.mUpdateDate = mUpdateDate; // 생성날짜 받기
        this.mEmotion = mEmotion; // 감정 받기

    }
}
