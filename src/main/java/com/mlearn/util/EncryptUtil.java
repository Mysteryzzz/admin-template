package com.mlearn.util;

import java.security.MessageDigest;
import java.util.UUID;

public class EncryptUtil {

    private static String DEFAULT_ENCODING = "UTF-8";
    private static String SHA_256 = "SHA-256";


    public static String encrypt(String password, String salt) {

        String encryptString = digest(password + salt, SHA_256, DEFAULT_ENCODING);
        return encryptString;
    }

    public static String createSalt() {
        return UUID.randomUUID().toString();
    }

    public static String digest(String str, String alg, String charEncoding) {
        try {
            byte[] data = str.getBytes(charEncoding);
            MessageDigest md = MessageDigest.getInstance(alg);
            return HexUtil.toHex(md.digest(data));
        } catch (Exception var5) {
            throw new RuntimeException("digest fail!", var5);
        }
    }

}
