package com.jyanedu.app.dao;

import com.jyanedu.app.beans.Catalog;
import com.jyanedu.app.beans.Movie;
import com.jyanedu.app.beans.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
public interface ProgramDao extends JpaRepository<Program,String> {
    List<Program> findByCatalogsContains(Catalog catalog);
    List<Program> findByIdIn(String[] ids);
}
