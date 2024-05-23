package com.example.springboot03;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class TokenGenerator {
    private static final long validityInMilliseconds = 1000L * 60 * 60;
    private static final String MEMBER_ID_CLAIM_KEY = "Id";

    private final byte[] secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    private String generateToken(String id) {
        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(Keys.hmacShaKeyFor(secretKey))
                .compact();
    }

    public String getToken(String id) {
        Random rand = new Random();
        int key = rand.nextInt(1000);
        System.out.println("call get token");
        return generateToken(id);
    }

    public Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}