package com.jyanedu.app.beans.tangram;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/8.
 */
public abstract class BaseContainer {
    protected String type;
    @Id
    private String id;
    protected List<BaseItem> items;

    public BaseContainer(String type) {
        this.type = type;
    }

    public BaseContainer(String type, String id) {
        this.type = type;
        this.id = id;
        items = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public List<BaseItem> getItems() {
        return items;
    }

    public void setItems(List<BaseItem> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
