package com.portfolio.Controller;

import com.portfolio.entity.UserDTO;
import com.portfolio.services.IAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private IAuthService service;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO user, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return this.service.login(request, response, user);
    }

    @GetMapping("/validate")
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return this.service.validate(request, response);
    }

}
