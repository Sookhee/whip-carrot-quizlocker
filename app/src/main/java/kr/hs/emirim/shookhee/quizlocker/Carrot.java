package kr.hs.emirim.shookhee.quizlocker;

public class Carrot {
    private String name;
    private String info;
    private int imgId;

    public Carrot(){};
    public Carrot(String name, String info, int imgId){
        this.name = name;
        this.info = info;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
