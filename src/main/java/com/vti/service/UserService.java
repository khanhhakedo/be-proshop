package com.vti.service;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.form.CreatingUserForm;
import com.vti.form.UpdateUserForm;
import com.vti.repository.RoleRepository;
import com.vti.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements  IUserService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    @Override
    public User getById(Integer id) {
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public void createUser(CreatingUserForm form) {
//        User user = modelMapper.map(form, User.class);
//        userRepository.save(user);


        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User user = new User();
        user.setUserName(form.getUserName());
        user.setUserPassword(getEncodedPassword(form.getUserPassword()));
        user.setEmail(form.getEmail());
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    @Override
    public List<User> findByUserName(String username) {
        List<User> users = userRepository.findByUserName(username);
        return users;
    }

    @Override
    public User getByUserName(String username) {
        User user = userRepository.getByUserName(username);
        return user;
    }

    @Override
    public void updateUser(Integer id, UpdateUserForm form) {
        User user = userRepository.getById(id);

        user.setUserName(form.getUsername());
        user.setEmail(form.getEmail());
        user.setUserPassword(getEncodedPassword(form.getPassword()));
        userRepository.save(user);


    }

    @Override
    @Transactional
    public List<User> loginUser(String userName, String password) {
        List<User> users = userRepository.loginUser(userName,password);
        return users;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}



