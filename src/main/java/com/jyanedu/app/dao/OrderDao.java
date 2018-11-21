package com.jyanedu.app.dao;

import com.jyanedu.app.beans.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liu_kai on 2018/3/1.
 */
public interface OrderDao extends JpaRepository<Order,String> {
}
