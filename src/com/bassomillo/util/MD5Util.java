package com.bassomillo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MD5Util {
    public static String digest(String content){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(content.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encode = encoder.encode(digest);
            return new String(encode);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
