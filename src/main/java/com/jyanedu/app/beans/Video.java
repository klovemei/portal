package com.jyanedu.app.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by liu_kai on 2018/2/1.
 */
@Entity
public class Video extends BaseBean{
    @Column(length = 256)
    private String playUrl;
    private VideoType videoType;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie;

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}