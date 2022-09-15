package com.vti.repository;

import com.vti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getByUserName(String username);
    User getById(Integer id);

    List<User> findByUserName(String username);


    //login
    @Modifying
    @Query("SELECT u FROM User AS u WHERE u.userName = :userName AND u.userPassword = :password  ")
    List<User> loginUser(String userName,String password);

    @Modifying
    @Query("DELETE FROM User AS u WHERE u.id = :id")
    void deleteById(Integer id);
}
