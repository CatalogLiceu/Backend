package com.example.catalogliceu.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String cheie = "cheie_12345678";

    public String genereazaToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, cheie)
                .compact();
    }

    public Claims extragerePermisii(String token) {
        return Jwts.parser()
                .setSigningKey(cheie)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extragePorecla(String token) {
        return extragerePermisii(token).getSubject();
    }

    public boolean jwtExpirat(String token) {
        return extragerePermisii(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String porecla) {
        return (porecla.equals(extragePorecla(token)) && !jwtExpirat(token));
    }
}