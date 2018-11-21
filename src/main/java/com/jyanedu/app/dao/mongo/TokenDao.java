package com.jyanedu.app.dao.mongo;

import com.jyanedu.app.beans.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by liu_kai on 2018/3/1.
 */
public interface TokenDao extends MongoRepository<Token,String>{
    Token findByUserIdOrderByExpTimestampDesc(String userId);
    void deleteAllByUserId(String userId);
}
