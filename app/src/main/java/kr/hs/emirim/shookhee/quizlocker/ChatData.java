package kr.hs.emirim.shookhee.quizlocker;

public class ChatData {

    private int imageID;
    private String nickname;
    private String msg;

    public ChatData(){}

    public ChatData(int imageID, String nickname, String msg) {
        this.imageID = imageID;
        this.nickname = nickname;
        this.msg = msg;
    }
    //private String time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getImageID() { return imageID; }

    public void setImageID(int imageID) { this.imageID = imageID; }
}
