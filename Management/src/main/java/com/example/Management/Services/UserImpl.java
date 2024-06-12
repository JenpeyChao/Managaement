package com.example.Management.Services;

import com.example.Management.Entity.Users;
import com.example.Management.Repository.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserImpl implements UserServices{

    @Autowired
    UserDAO userDAO;

    @Override
    public List<Users> getAllUsers() {
        log.info("Getting all the Users");
        return this.userDAO.findAll();
    }

    @Override
    public Users getUsersById(long userId) {
        Optional<Users> context = this.userDAO.findById(userId);
        Users user = null;
        if(context.isPresent()){
            user = context.get();
            log.info("Getting user {}",userId);
        }else{
            log.error("User {} not found", userId);
            throw new RuntimeException(userId + " Not found");

        }
        return user;
    }

    @Override
    public Users addUsers(Users users) {
        log.info("Adding new user {}",users);
        return this.userDAO.save(users);
    }

    @Override
    public Users updateUsers(Users users) {
        log.info("Updating new user {}",users);
        return this.userDAO.save(users);

    }

    @Override
    public String deleteUsers(long userId) {
        this.userDAO.deleteById(userId);
        log.info("{} user deleted", userId);
        return "User Deleted";
    }

    public List<Users> findUserByName(String name){
        log.info("Getting user by name:{}",name);
        return this.userDAO.findUserByName(name);
    }
    public List<Users> findUsersByPhoneNumber(String phone_number){
        log.info("Getting user by the phone number: {}",phone_number);
        return this.userDAO.findUsersByPhoneNumber(phone_number);
    }
    public List<Users> findUsersByEmail(String email){
        log.info("Getting user by the email: ")
        return this.userDAO.findUsersByEmail(email);
    }
}
