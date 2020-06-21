package kr.hs.emirim.shookhee.quizlocker;

public class User {
    private int id;
    private String userId;
    private String userPw;
    private String nickname;
    private String profile;
    private int carrot;

    public String getUserId() { return userId; }
    public void setUiserId(String userId) { this.userId = userId; }

    public String getUserPw() { return userPw; }
    public void setUiserPw(String userPw) { this.userPw = userPw; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }

    public int getCarrot() { return carrot; }
    public void setCarrot(int carrot) { this.carrot = carrot; }

    @Override
    public String toString() {
        return "User{"+
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profile='" + profile + '\'' +
                ", carrot='" + carrot + '\'' +
                '}';
    }
}
