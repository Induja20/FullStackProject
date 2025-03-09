package com.Springboot.Foodorder.controller;
import com.Springboot.Foodorder.model.LoginModel;
import com.Springboot.Foodorder.repository.LoginRepository;
import com.Springboot.Foodorder.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("/foodorderapplication")
@CrossOrigin(origins = "http://localhost:5173") // ✅ Allow frontend to access backend
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginModel login) {
        return loginService.authenticateUser(login);
    }
}

