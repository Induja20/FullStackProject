package com.Springboot.Foodorder.service;

import com.Springboot.Foodorder.model.LoginModel;
import com.Springboot.Foodorder.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public String authenticateUser(LoginModel login) {
        Optional<LoginModel> user = loginRepository.findByUsername(login.getUsername());

        // ✅ Fix authentication check
        if (user.isPresent()) {
            LoginModel foundUser = user.get();
            if (foundUser.getPassword().equals(login.getPassword())) {
                return "Login Successful";
            }
        }
        return "Invalid Credentials";
    }
}
