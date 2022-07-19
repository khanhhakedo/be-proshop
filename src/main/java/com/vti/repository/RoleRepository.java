package com.vti.repository;

import com.vti.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

    Set<Role> getByRoleName(String rolename);

}
