package cn.kevinwang.old_people_service.util;

import cn.hutool.crypto.digest.BCrypt;

/**
 * @author wang
 * @create 2024-01-30-12:01
 */
public class EcryptUtil {
    public static  String encode(String password){
        return BCrypt.hashpw(password);
    }

    public static boolean verify(String password,String encodePassword){
        return BCrypt.checkpw(password,encodePassword);
    }

    public static boolean matches(String password, String password1) {
        return BCrypt.checkpw(password,password1);
    }
}
