package com.jyanedu.app.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
public class Movie extends BaseBean{
    @Column(length = 128)
    private String name;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Program program;
//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private List<Video> videos = null;
    @Column(name = "data_index")
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
