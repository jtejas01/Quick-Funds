package com.app.quickFund.repositories;

import com.app.quickFund.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


    Optional<UserEntity> findByEmail(String emailId);

    Optional<UserEntity> findByPhone(String phone);
}
