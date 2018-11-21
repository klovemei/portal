package com.jyanedu.app.dao;

import com.jyanedu.app.beans.Page;
import com.jyanedu.app.beans.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/8.
 */
@Component
public class MongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void saveObject(Object object){
        mongoTemplate.save(object);
    }
    public Page getPage(String id){
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),Page.class);
    }
    public Token getToken(String id){
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),Token.class);
    }
    public Token getTokenByUserId(String userId){
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)),Token.class);
    }
}
