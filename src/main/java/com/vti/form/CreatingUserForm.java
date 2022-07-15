package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingUserForm {

    private String username;

    private String email;

    private String password;
}
