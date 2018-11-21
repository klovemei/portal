package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/9.
 */
public class ImgItem extends BaseItem{
    private static final String type = "S-Img";
    private String imgUrl;
    private double ratio;
    private int isMaxWidth;
    public ImgItem() {
        super(type);
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getIsMaxWidth() {
        return isMaxWidth;
    }

    public void setIsMaxWidth(int isMaxWidth) {
        this.isMaxWidth = isMaxWidth;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
