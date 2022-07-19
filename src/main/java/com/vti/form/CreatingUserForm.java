package com.vti.form;

import com.vti.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CreatingUserForm {

    private Integer id;
    private String userName;

    private String email;

    private String userPassword;
    private String role;
}
