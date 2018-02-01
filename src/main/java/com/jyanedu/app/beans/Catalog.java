package com.jyanedu.app.beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
public class Catalog extends BaseBean{
    private String catalogName;
    @ManyToOne
    private Catalog parent;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Catalog getParent() {
        return parent;
    }

    public void setParent(Catalog parent) {
        this.parent = parent;
    }
}
