package com.jyanedu.app.beans;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by liu_kai on 2018/2/1.
 */
@MappedSuperclass
public class BaseBean {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
