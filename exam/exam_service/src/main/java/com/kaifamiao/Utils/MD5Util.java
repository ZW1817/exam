package com.kaifamiao.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {
    public static String encode(String msg){
        MessageDigest md5=null;
        try {
            md5=MessageDigest.getInstance("MD5");
            //转换为MD5码
            byte[] digest=md5.digest(msg.getBytes("utf-8"));
            return new BigInteger(1,md5.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String pass="123";
        System.out.println(encode(pass));
    }
}
