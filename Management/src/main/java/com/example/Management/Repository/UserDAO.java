package com.example.Management.Repository;

import com.example.Management.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users, Long> {
}
