package com.jyanedu.app.dao;

import com.jyanedu.app.beans.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/7.
 */
public interface CatalogDao extends JpaRepository<Catalog,String> {
    List<Catalog> findByIdNotNullOrderByIdAsc();

}
