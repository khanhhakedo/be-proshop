package com.vti.controller;

import com.vti.form.CreatingUserForm;
import com.vti.form.UpdateUserForm;
import com.vti.repository.UserRepository;
import com.vti.service.UserService;
import com.vti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @GetMapping("byname/{username}")
    public ResponseEntity<?> getAllArticleByName(@PathVariable("username") String username){

        User user = userRepository.getUserByUserName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // tao moi user
    @PostMapping({"/createNewUser"})
    public ResponseEntity<?> createNewUser(@RequestBody CreatingUserForm form) {
        userService.createUser(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }

//    // sua user  theo username
//    @PutMapping(value = "/update/{username}")
//    public ResponseEntity<?> updateUser(@PathVariable(name = "username") String username, @RequestBody UpdateUserForm form) {
//
//        userService.updateUser(username,form);
//        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
