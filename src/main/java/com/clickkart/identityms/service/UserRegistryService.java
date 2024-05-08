package com.clickkart.identityms.service;

import com.clickkart.identityms.dao.User;
import com.clickkart.identityms.dto.UserRegister;
import com.clickkart.identityms.repository.UserRepository;
import com.clickkart.identityms.utility.UserUtility;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRegistryService {

    private final UserUtility userUtility;

    private final UserRepository userRepository;

    public UserRegistryService(final UserUtility userUtility, final UserRepository userRepository){
        this.userUtility = userUtility;
        this.userRepository = userRepository;
    }

    public void userRegistrationService(UserRegister userRegister){
        String encryptedPassword = userUtility.encodePassword(userRegister.getPassword());
        User user = new User();
        user.setUserName(userRegister.getUserName());
        user.setEmail(userRegister.getEmail());
        user.setPassword(encryptedPassword);
        user.setCreationDate(new Date());
        user.setLastModifiedOn(new Date());
        userRepository.save(user);
        // Code to push event to notification service
    }
}
