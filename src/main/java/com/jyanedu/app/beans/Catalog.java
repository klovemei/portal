package com.jyanedu.app.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
@DynamicUpdate
public class Catalog extends BaseBean{
    private String catalogName;
    @JsonBackReference
    @ManyToOne
    private Catalog parent;
    @Column(length = 1024)
    private String catalogImgUrl;

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

    public String getCatalogImgUrl() {
        return catalogImgUrl;
    }

    public void setCatalogImgUrl(String catalogImgUrl) {
        this.catalogImgUrl = catalogImgUrl;
    }
}
