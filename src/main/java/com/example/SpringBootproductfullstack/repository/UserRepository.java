package com.example.SpringBootproductfullstack.repository;

import com.example.SpringBootproductfullstack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User searchByEmailId(@Param("email_id") String email_id);
}
