package com.example.Management.Controller;

import com.example.Management.Entity.Users;
import com.example.Management.Services.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserImpl users;

    @GetMapping("/")
    public String home(){
        return "<h1> Welcome to user management </h1>";
    }
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return this.users.getAllUsers();
    }
    @GetMapping("/users/name")
    public List<Users> findUserByName(@RequestParam String name){
        return this.users.findUserByName(name);
    }
    @GetMapping("/users/phone_number")
    public List<Users> findUsersByPhoneNumber(@RequestParam String phone_number){
        return this.users.findUsersByPhoneNumber(phone_number);
    }
    @GetMapping("/users/email")
    public List<Users> findUsersByEmail(@RequestParam String email){
        return this.users.findUsersByEmail(email);
    }
    @GetMapping("/users/{userId}")
    public Users getUsersById(@PathVariable long userId) {
        return this.users.getUsersById(userId);
    }
    @PostMapping("/users")
    public Users addUsers(@RequestBody Users users) {
        return this.users.addUsers(users);
    }
    @PutMapping("/users")
    public Users updateUsers(@RequestBody Users users) {
        return this.users.updateUsers(users);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUsers(@PathVariable long userId) {
        return this.users.deleteUsers(userId);
    }

}
