package com.clickkart.identityms.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUtility {

    private final BCryptPasswordEncoder passwordEncoder;


    public UserUtility(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

}
