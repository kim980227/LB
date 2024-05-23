package com.example.springboot03;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenVerifier {
    private final TokenGenerator tokenGenerator;
    private final Map<Integer, String> map;

    public TokenVerifier(@Autowired TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
        this.map = new HashMap<>();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = tokenGenerator.getClaims(token);
            return claims != null && !isTokenExpired(claims);
        } catch (MalformedJwtException e) {
            System.err.println("Invalid token format: " + e.getMessage());
            return false; // Indicate that the token is invalid.
        } catch(ExpiredJwtException e){
            System.err.println("Expired token format: " + e.getMessage());
            return false;
        }
    }


    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    public void tokenMapper(String token) {
        map.put(map.size() + 1, token);
    }

    public Map<Integer, String> getMappedTokens() {
        return new HashMap<>(map);
    }
}