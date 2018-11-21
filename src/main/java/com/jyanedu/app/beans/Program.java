package com.jyanedu.app.beans;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
@DynamicUpdate
public class Program extends BaseBean{
    @Column(length = 1024,name = "program_desc")
    private String desc;
    @Column(length = 10)
    private String type;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "program",fetch = FetchType.LAZY)
    @OrderBy("data_index asc")
    private List<Movie> movies = null;
    private String imgUrl;
    private String name;
    private int money;
    private String validityTime;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Catalog> catalogs = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(String validityTime) {
        this.validityTime = validityTime;
    }
}
