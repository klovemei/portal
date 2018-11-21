package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/9.
 */
public class SplitItem extends BaseItem{
    private static final String type = "split";
    private String text;
    public SplitItem() {
        super(type);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
