package com.clickkart.identityms.utility;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUtility {

    private final PasswordEncoder passwordEncoder;


    public UserUtility(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

}
