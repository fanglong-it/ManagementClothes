package fang.ecommerce.clothes.validate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Decryptor {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String rawPass = "123456";
        String newPass = bCryptPasswordEncoder.encode(rawPass);
        System.out.println("" + newPass);
    }
}
