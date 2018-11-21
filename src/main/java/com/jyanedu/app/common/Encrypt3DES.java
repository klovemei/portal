package com.jyanedu.app.common;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by liu_kai on 2018/3/20.
 */
public class Encrypt3DES {
    public static String  getKey() throws NoSuchAlgorithmException {
        //生成key
        KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
        //keyGenerator.init(112);      //3DES需要112 or 168位
        keyGenerator.init(new SecureRandom());   //或者使用这种方式默认长度，无需指定长度
        SecretKey secretKey = keyGenerator.generateKey(); //生成key的材料
        byte[] key = secretKey.getEncoded();  //生成key
        return Base64.encodeBase64String(key);
    }
    public static String encrypt(String data, String key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec desKeySpec=new DESedeKeySpec(Base64.decodeBase64(key));
        SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
        SecretKey key2 = factory.generateSecret(desKeySpec);      //转换后的密钥
        Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");  //算法类型/工作方式/填充方式
        cipher.init(Cipher.ENCRYPT_MODE, key2);   //指定为加密模式
        byte[] result=cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(result);
    }
    public static String decrypt(String data,String key) throws  InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec desKeySpec=new DESedeKeySpec(Base64.decodeBase64(key));
        SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
        SecretKey key2 = factory.generateSecret(desKeySpec);      //转换后的密钥
        Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");  //算法类型/工作方式/填充方式
        cipher.init(Cipher.DECRYPT_MODE,key2);  //相同密钥，指定为解密模式
        byte[] result=cipher.doFinal(data.getBytes());
        result = cipher.doFinal(result);   //根据加密内容解密
        return new String(result);
    }
}
