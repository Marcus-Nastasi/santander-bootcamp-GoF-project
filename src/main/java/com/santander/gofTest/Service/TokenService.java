package com.santander.gofTest.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.santander.gofTest.Models.Users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${spring.api.security.token.secret}")
    private String secret;

    @Bean
    public String generate(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT
                    .create()
                    .withIssuer("api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(getInstant())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return "";
        }
    }

    @Bean
    public String validate(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("api").build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    @Bean
    private Instant getInstant() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}



