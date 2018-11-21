package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/8.
 */
public class BaseItem {
    public BaseItem(String type) {
        this.type = type;
    }

    protected String type;
    private String onclick;
    private String onclickId;
    public String getType() {
        return type;
    }

    public String getOnclickId() {
        return onclickId;
    }

    public void setOnclickId(String onclickId) {
        this.onclickId = onclickId;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }
}
