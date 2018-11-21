package com.jyanedu.app.dao;

import com.jyanedu.app.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liu_kai on 2018/3/1.
 */
public interface UserDao extends JpaRepository<User,String> {
    User findByPhoneAndPwd(String phone,String pwd);
}
