package com.portfolio.security;

import com.portfolio.entity.User;
import com.portfolio.entity.UserDTO;
import com.portfolio.repository.IUserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class AuthManager {
    @Autowired
    private IUserRepository users;
    @Autowired
    private JwtProvider provider;

    public boolean validUser(UserDTO user){
        Optional<User> appUser = users.findByUsername(user.getUsername());
        if(appUser.isPresent()){
            return appUser.get().getPassword().equals(user.getPassword());
        }
        return false;
    }

    public boolean validToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String token = request.getHeader("Authorization");
            if (token != null) {
                return true;
            } else
                response.sendError(403, "Empty Token");
        } catch (MalformedJwtException e) {
            response.sendError(403, "Invalid Token");
        } catch (UnsupportedJwtException e) {
            response.sendError(403, "Token not supported");
        } catch (ExpiredJwtException e) {
            response.sendError(403, "Token expired");
        } catch (IllegalArgumentException e) {
            response.sendError(403, "Empty Token");
        } catch (SignatureException e) {
            response.sendError(403, "Invalid Token");
        }
        response.setStatus(403);
        return false;
    }

}
