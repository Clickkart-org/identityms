package com.clickkart.identityms.service;

import com.clickkart.identityms.contants.ErrorConstants;
import com.clickkart.identityms.dao.User;
import com.clickkart.identityms.dto.UserRegister;
import com.clickkart.identityms.exception.BadRequestException;
import com.clickkart.identityms.repository.UserRepository;
import com.clickkart.identityms.utility.UserUtility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistryService {

    private final UserUtility userUtility;

    private final UserRepository userRepository;

    public UserRegistryService(final UserUtility userUtility, final UserRepository userRepository){
        this.userUtility = userUtility;
        this.userRepository = userRepository;
    }

    public void userRegistrationService(UserRegister userRegister){

        validateUserRegistration(userRegister);

        String encryptedPassword = userUtility.encodePassword(userRegister.getPassword());
        User user = new User();
        user.setUserName(userRegister.getUserName());
        user.setEmail(userRegister.getEmail());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        // Code to push event to notification service
    }

    public void validateUserRegistration(UserRegister userRegister){
        List<User> user = userRepository.findByEmail(userRegister.getEmail());
        if(!user.isEmpty())
            throw new BadRequestException(ErrorConstants.UserAlreadyExitsWithEmail);
    }
}
