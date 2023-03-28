package com.portfolio.security;

import com.portfolio.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user){
        return "Bearer " + Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.ES512, secret)
                .setIssuedAt(new Date())
                .compact();
    }

    public String getUserFromToken(String token){
        String userData = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(JwtProvider.getToken(token))
                .getBody()
                .getSubject();
        return null;
    }

    public static String getToken(String token){
        if(token != null){
            return token.replace("Bearer ", "");
        }
        return null;
    }

}
