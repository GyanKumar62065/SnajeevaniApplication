package sanjeevaniapplication.utils;


import java.util.Base64;

public class PasswordEncryption {
    public static String getEncryptedPassword(String password){
        return (new String(Base64.getEncoder().encodeToString(password.getBytes())));
    }
}



