package com.youtube.jwt.form;

import lombok.Data;

@Data
public class GetUserFormToken {
    private String email;
    private String password;
}
