package com.devConenct.user_service.infrastructure.repository;

import com.devConenct.user_service.domain.model.User;
import com.devConenct.user_service.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Long>, UserRepository {

}
