package com.jyanedu.app.module;

import com.jyanedu.app.beans.Token;
import com.jyanedu.app.beans.User;

/**
 * Created by liu_kai on 2018/3/1.
 */
public class LoginResp extends BaseResp{
    private User user;
    private Token token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
