package com.jyanedu.app.service;

import com.jyanedu.app.beans.Token;
import com.jyanedu.app.beans.User;
import com.jyanedu.app.common.MD5;
import com.jyanedu.app.common.StaticProp;
import com.jyanedu.app.dao.UserDao;
import com.jyanedu.app.dao.mongo.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by liu_kai on 2018/3/1.
 */
@Service
public class TokenService {
    @Autowired
    TokenDao tokenDao;
    @Autowired
    UserDao userDao;
    public Token getToken(String phone,String pwd){
        User user = userDao.findByPhoneAndPwd(phone,pwd);
        if(user==null)return null;
        Token token = tokenDao.findByUserIdOrderByExpTimestampDesc(user.getId());
        if(token!=null&&token.getExpTimestamp()>System.currentTimeMillis()){

        }else {
            token = new Token();
            token.setUserId(user.getId());
            token.setExpTimestamp(System.currentTimeMillis()+ StaticProp.tokenExpTime);
            token.setTokenStr(UUID.randomUUID().toString());
            tokenDao.deleteAllByUserId(user.getId());
            tokenDao.save(token);
        }
        return token;
    }

    public boolean checkToken(HttpServletRequest request){
        try {
            Enumeration<String> names = request.getParameterNames();
            String sign = request.getParameter("sign");
            String signStr = "";
            String userId = request.getParameter("userId");
            List<String> keyList = new ArrayList<>();
            while (names.hasMoreElements()){
                String key = names.nextElement();
                if(!key.equals("sign")){
                    keyList.add(key);
                }
            }
            Collections.sort(keyList);
            for (String key:keyList){
                signStr+=request.getParameter(key);
            }
            Token token = tokenDao.findByUserIdOrderByExpTimestampDesc(userId);
            signStr+=token.getTokenStr();
            String signC = MD5.getMD5(signStr);
            if(signC.equals(sign))return true;else return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
