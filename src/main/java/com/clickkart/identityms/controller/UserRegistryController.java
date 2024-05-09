package com.clickkart.identityms.controller;

import com.clickkart.identityms.dto.UserRegister;
import com.clickkart.identityms.service.UserRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class UserRegistryController {
    private final UserRegistryService userRegistryService;

    public UserRegistryController(final UserRegistryService userRegistryService){
        this.userRegistryService = userRegistryService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserRegister userRegister){
    log.debug("Inside the User registration Method");
    log.trace("The employee name is "+ userRegister.getUserName() +"and the email is "+userRegister.getEmail());
    userRegistryService.userRegistrationService(userRegister);
    return new ResponseEntity<>("User successfully created",HttpStatus.CREATED);
    }

}
