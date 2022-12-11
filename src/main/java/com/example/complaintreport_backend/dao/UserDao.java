package com.example.complaintreport_backend.dao;


import com.example.complaintreport_backend.model.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserDetails,Integer> {
    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `userdetails` WHERE `username`= :username AND `password`= :password", nativeQuery = true)
    List<UserDetails> UserLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `userdetails` WHERE `username`= :username",nativeQuery = true)
    List<UserDetails> FindUser(@Param("username") String username);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `userdetails` WHERE `id`= :id",nativeQuery = true)
    List<UserDetails> FindUserById(@Param("id") String id);
}