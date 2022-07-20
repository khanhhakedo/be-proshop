package com.vti.form;

import com.vti.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserForm {
    private String username;
    private String email;

    private String password;


    public UpdateUserForm() {
        super();
    }

}
