package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/9.
 */
public class ItemImgText extends BaseItem{
    private static final String type = "Img-Text";

    public ItemImgText() {
        super(type);
    }
    private String text;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
