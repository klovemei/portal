package com.jyanedu.app.common;

/**
 * Created by liu_kai on 2018/3/9.
 */
public class Base64UrlUtil {

    public static String base64Url(String base64){
        base64 = base64.replace('+','-');
        base64 = base64.replace('/','_');
        base64 = base64.replace('=','.');
        return base64;
    }
    public static String urlBase64(String base64){
        base64 = base64.replace('-','+');
        base64 = base64.replace('_','/');
        base64 = base64.replace('.','=');
        return base64;
    }
}
