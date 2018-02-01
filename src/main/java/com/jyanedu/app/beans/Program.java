package com.jyanedu.app.beans;


import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
public class Program extends BaseBean{
    @Column(length = 1024)
    private String detail;
    @Column(length = 10)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
