package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingUserForm {

    private String link ;
    private Integer id;
    private String userName;

    private String email;

    private String userPassword;
    private String role;
}
