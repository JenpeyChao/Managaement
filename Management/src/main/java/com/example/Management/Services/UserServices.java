package com.example.Management.Services;

import com.example.Management.Entity.Users;

import java.util.List;

public interface UserServices {
    List<Users> getAllUsers();
    Users getUsersById(long userId);
    Users addUsers(Users users);
    Users updateUsers(Users users);
    String deleteUsers(long userId);
}
