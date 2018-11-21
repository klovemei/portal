package com.jyanedu.app.controller;

import com.jyanedu.app.beans.Token;
import com.jyanedu.app.beans.User;
import com.jyanedu.app.common.Base64UrlUtil;
import com.jyanedu.app.common.Encrypt3DES;
import com.jyanedu.app.common.RSAEncrypt;
import com.jyanedu.app.dao.UserDao;
import com.jyanedu.app.exception.DefException;
import com.jyanedu.app.module.LoginResp;
import com.jyanedu.app.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.interfaces.RSAPrivateKey;

/**
 * Created by liu_kai on 2018/3/1.
 */
@RestController
public class UserController {
    private RSAPrivateKey privateKey;
    @Autowired
    UserDao userDao;
    @Autowired
    TokenService tokenService;
    public UserController() {
        try {
            privateKey = RSAEncrypt.loadPrivateKeyByStr("MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAIahyI/jDEH55JPNQJu1A/cXMhPpGiotmQXqxm8yUe8YHD3oc88aMGvuBrMzNnEgm3THoQDjab+AVkph6I3iD2X+cydc/A/a5CdnB5hZQV7ZgqADdI8TnoxW4H3I59z5nwTUonSDLwFXseocjzg2p314Y3HY2wMo/TEIwN+1q1uFAgMBAAECgYEAgIn4PgBNlLQsmzzNIZx606+OvVnCBGESh4a2vDWz6m3/kM/due7MKk/Qj8kmgm3aXm22d22oahDy0gOWj9g0UA7sqg6aM07zuX+Ae21iPh4laPkER6EEEhwU7tLieGhFJSFuyflswvwvsNpSVNo//CoLbbYk1fKOgXvlvREuCAUCQQDC2Y9E6njC70EbFlVDd1ylFn5J9FFOGN48Qb7LarAZuUNysyLOcSwkWkdXHuulwUj4bFO7dNOXs7CNyuC4OXB/AkEAsOJBsRacVHOEVRc8/2s/Kx3SoPwJ9BEPRu3kxkqUl2ii2K/Jd5sEj/BrRaHbX031x4EXX8ErPtYZ3QvMjE5x+wJBAL1mbPU4VZpmpoqF8utZoxx1+Nw6OK4JTjyUS7m/Qt4+T2m25yZ0q8vKVX5B+B1u/Fc+NUYKEYNsjznE8xsf+lECQHzdu/H/PCyBv5Ex7mWAl/8f9mieg4g/4sD3fuBcFbksrIi6z0YXsIjL924YbHxC1JYZkx6NhrG9AlUA10zUs7ECQQCeO7yzXfs1p36yWGKmK170N9MqyeKxF+d5S2pGldTVdsJEG3sqZmIdLIUdEo+bdEhSFcbqSQ+rMoc0XSyc3qXE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login")
    public LoginResp login(String phone,String password,String key) throws DefException {
        if(phone==null||password==null||key==null){
            throw new DefException();
        }
        LoginResp loginResp = new LoginResp();
        password = Base64UrlUtil.urlBase64(password);
        key = Base64UrlUtil.urlBase64(key);
        System.out.println(password);
        System.out.println(key);
        try {
            password = new String(RSAEncrypt.decrypt(privateKey, new BASE64Decoder().decodeBuffer(password)));
            key = new String(RSAEncrypt.decrypt(privateKey, new BASE64Decoder().decodeBuffer(key)));
            User user = userDao.findByPhoneAndPwd(phone,password);
            if(user==null)throw new DefException();
            loginResp.setUser(user);
            Token token = tokenService.getToken(phone,password);
            token.setTokenStr(Base64UrlUtil.base64Url(Encrypt3DES.encrypt(token.getTokenStr(),key)));
            loginResp.setToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefException();
        }
        return loginResp;
    }
    @RequestMapping(value = "/reg")
    public LoginResp reg(String phone, String password,String key) throws DefException{
        if(phone==null||password==null||key==null){
            throw new DefException();
        }
        LoginResp loginResp = new LoginResp();
        password = Base64UrlUtil.urlBase64(password);
        key = Base64UrlUtil.urlBase64(key);
        try {
            password = new String(RSAEncrypt.decrypt(privateKey, new BASE64Decoder().decodeBuffer(password)));
            key = new String(RSAEncrypt.decrypt(privateKey, new BASE64Decoder().decodeBuffer(key)));
            User user = new User();
            user.setPhone(phone);
            user.setPwd(password);
            userDao.save(user);
            loginResp.setUser(user);
            Token token = tokenService.getToken(phone,password);
            token.setTokenStr(Base64UrlUtil.base64Url(Encrypt3DES.encrypt(token.getTokenStr(),key)));
            loginResp.setToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefException();
        }
        return loginResp;
    }

}
