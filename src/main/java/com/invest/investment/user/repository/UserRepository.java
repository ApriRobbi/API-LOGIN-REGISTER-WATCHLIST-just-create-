package com.invest.investment.user.repository;

import com.invest.investment.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    UserEntity findByEmailAndPassword(String email, String password);
}
