package com.Springboot.Foodorder.repository;



import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Springboot.Foodorder.model.LoginModel;



public interface LoginRepository extends JpaRepository<LoginModel, Long> {

    Optional<LoginModel> findByUsername(String username);

}

