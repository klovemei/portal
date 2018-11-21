package com.jyanedu.app.beans;

import com.jyanedu.app.beans.tangram.BaseContainer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/8.
 */
public class Page {
    @Id
    private String id;
    private List<BaseContainer> containers;
    @CreatedDate
    private Date createdDate = new Date();
    @LastModifiedDate
    private Date lastModifiedDate = new Date();

    public Page(String id) {
        this.id = id;
        containers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BaseContainer> getContainers() {
        return containers;
    }

    public void setContainers(List<BaseContainer> containers) {
        this.containers = containers;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
