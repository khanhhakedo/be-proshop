package com.vti.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    private String roleName;


    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
