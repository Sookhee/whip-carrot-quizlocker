package kr.hs.emirim.shookhee.quizlocker.model;

public class Chat {
    private String chat_user;
    private String chat_message;
    private int profile_id;

    public Chat(){}
    public Chat(String chat_user, String chat_message, int profile_id) {
        this.chat_user = chat_user;
        this.chat_message = chat_message;
        this.profile_id = profile_id;
    }

    public void setChat_user(String chat_user) {
        this.chat_user = chat_user;
    }

    public void setChat_message(String chat_message) {
        this.chat_message = chat_message;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getChat_user() {
        return chat_user;
    }

    public String getChat_message() {
        return chat_message;
    }

    public int getProfile_id() {
        return profile_id;
    }
}
