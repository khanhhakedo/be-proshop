package com.vti.service;

import com.vti.entity.User;
import com.vti.form.CreatingUserForm;
import com.vti.form.UpdateUserForm;

import java.util.List;

public interface IUserService {
    User getById(Integer id);

    public  void  createUser(CreatingUserForm form);
    List<User> findByUserName(String username);
    User getByUserName(String username);
    public void updateUser(Integer id, UpdateUserForm form);

    List<User> loginUser(String userName,String password);

    public void deleteById(Integer id);
    List<User> getAll();
}
