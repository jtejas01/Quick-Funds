package com.app.quickFund.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.cert.X509CertSelector;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtUtil {
    private final String SECRET_KEY = "my-super-secure-secret-key-1234567890";

    public String genrateAccessToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .compact();
    }
    private Key getSiningKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    public String generateRefreshToken(){
        return UUID.randomUUID().toString();
    }
    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }
    public boolean validateToken(String token,UserDetails userDetails){
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSiningKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }
}
