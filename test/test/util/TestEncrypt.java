package test.util;

import com.mlearn.util.EncryptUtil;

public class TestEncrypt {


    public static void main(String[] args) {


        String pass1 = "123456";
        String pass2 = "1";
        String pass3 = "16";
        String pass4 = "13456";

        String salt1 = EncryptUtil.createSalt();
        System.out.println(EncryptUtil.encrypt(pass1, salt1));
        System.out.println(salt1);


        String password = "d46f3cfb336030df9f5a80b71f491084022f12013bc86e4c0a4bf8011056c4d1";
        String salt = "a85e12ca-5e74-4113-9508-cfb0a68edf94";
        System.out.println("##############################");

        System.out.println(EncryptUtil.encrypt(pass1, salt));

        System.out.println("##############################");

        System.out.println(password.equals(EncryptUtil.encrypt(pass1, salt)));

        System.out.println("##############################");

        System.out.println(EncryptUtil.encrypt(pass2, salt1));
        System.out.println(EncryptUtil.encrypt(pass3, salt1));
        System.out.println(EncryptUtil.encrypt(pass4, salt1));


    }





}
