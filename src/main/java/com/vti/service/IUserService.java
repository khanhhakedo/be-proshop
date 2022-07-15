package com.vti.service;

import com.vti.form.CreatingUserForm;
import com.vti.form.UpdateUserForm;

public interface IUserService {

    public  void  createUser(CreatingUserForm form);
    public void updateUser(String username, UpdateUserForm form);
}
