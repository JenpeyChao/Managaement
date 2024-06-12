package com.example.Management.Repository;

import com.example.Management.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.name = :name")
    List<Users> findUserByName(@Param("name") String name);

    @Query("SELECT u FROM Users u WHERE u.phone_number = :phone_number")
    List<Users> findUsersByPhoneNumber(@Param("phone_number") String phone_number);

    @Query("SELECT u FROM Users u WHERE u.email = :email")
    List<Users> findUsersByEmail(@Param("email") String email);
}
