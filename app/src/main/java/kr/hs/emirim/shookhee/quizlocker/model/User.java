package kr.hs.emirim.shookhee.quizlocker.model;

public class User {
    private String nickname;
    private String email;
    private int carrotCount;
    private int profileId;

    public User(){}
    public User(String nickname, String email, int carrotCount, int profileId){
        this.nickname = nickname;
        this.email = email;
        this.carrotCount = carrotCount;
        this.profileId = profileId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCarrotCount() {
        return carrotCount;
    }

    public void setCarrotCount(int carrotCount) {
        this.carrotCount = carrotCount;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }
}
