package com.portfolio.services.impl;

import com.portfolio.entity.User;
import com.portfolio.entity.UserDTO;
import com.portfolio.repository.IUserRepository;
import com.portfolio.security.AuthManager;
import com.portfolio.security.JwtProvider;
import com.portfolio.services.IAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
@Service
public class IAuthServiceImpl implements IAuthService {
    @Autowired
    private IUserRepository users;
    @Autowired
    private JwtProvider provider;
    @Autowired
    private AuthManager authManager;

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response, UserDTO user) throws IOException {
        if(request.getHeader("Authorization") != null){
            response.setStatus(401);
            response.sendError(401, "You are already authenticate");
            return null;
        }
        if(authManager.validUser(user)){
            Optional<User> appUser = users.findByUsername(user.getUsername());
            response.setStatus(200);
            return provider.generateToken(appUser.get());
        }
        response.setStatus(401);
        response.sendError(401, "Invalid Credentials!");
        return null;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return this.authManager.validToken(request, response);
    }
}
