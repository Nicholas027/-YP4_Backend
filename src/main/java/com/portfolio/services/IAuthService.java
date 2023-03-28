package com.portfolio.services;

import com.portfolio.entity.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IAuthService {
    public String login(HttpServletRequest request, HttpServletResponse response, UserDTO user) throws IOException;

    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
