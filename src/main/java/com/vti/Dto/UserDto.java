package com.vti.Dto;

import com.vti.entity.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class UserDto {

    private String userName;
    private Integer id;
    private String email;
    private String role;
    private String token;
}
