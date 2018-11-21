package com.jyanedu.app.dao;

import com.jyanedu.app.beans.Movie;
import com.jyanedu.app.beans.Program;
import com.jyanedu.app.beans.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
public interface VideoDao  extends JpaRepository<Video,String> {
}
