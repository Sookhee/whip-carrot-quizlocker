package kr.hs.emirim.shookhee.quizlocker.model;

public class Carrot {
    private String name;
    private String info;
    private int imgId;
    private int unlockCount;

    public Carrot(){};
    public Carrot(String name, String info, int imgId, int unlockCount){
        this.name = name;
        this.info = info;
        this.imgId = imgId;
        this.unlockCount = unlockCount;
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

    public int getUnlockCount() {
        return unlockCount;
    }

    public void setUnlockCount(int unlockCount) {
        this.unlockCount = unlockCount;
    }
}
