package com.vti.controller;

import com.vti.Dto.UserDto;
import com.vti.entity.User;
import com.vti.form.CreatingUserForm;
import com.vti.form.UpdateUserForm;
import com.vti.service.EmailService;
import com.vti.service.UserService;
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
    private EmailService emailService;

    @Autowired
    private UserService userService;


//    @PostConstruct
//    public void initRoleAndUser() {
//        userService.initRoleAndUser();
//    }
    // get All dang list
    @GetMapping()
    public ResponseEntity<?> getAllListAccounts() {
        List<User> users = userService.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setEmail(user.getEmail());
            userDto.setRole(user.getRole().toString());
            userDtos.add(userDto);
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

//    // tao moi user
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody GetUserFormToken form) {
//        List<User> user = userService.loginUser(form.getUserName(), form.getUserPassword());
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }


    @GetMapping("/username/{userName}")
    public ResponseEntity<?> getByName(@PathVariable("userName") String userName){

        User user = userService.getByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){

        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable("id") Integer id){

        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    // tao moi user
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody CreatingUserForm form) {
        userService.createUser(form);
        String status = emailService.sendMailWithAttachment(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }

    // Sua Profile theo Id
    @PutMapping(value = "/profile/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Integer id, @RequestBody UpdateUserForm form) {
        userService.updateUser(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    // Sua User theo Id
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable(name = "id") Integer id, @RequestBody UpdateUserForm form) {
        userService.updateUser(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

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


    // Xoa User theo id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
