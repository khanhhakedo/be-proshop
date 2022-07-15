package com.vti.form;

import lombok.Data;

@Data
public class UpdateUserForm {
    private String username;

    private String email;

    private String password;
}
