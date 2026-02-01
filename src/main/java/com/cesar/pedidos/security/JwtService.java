package com.cesar.pedidos.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


@Service
public class JwtService {

    private static final String SECRET = "chave-secreta-forte";

    public String gerarToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(
                        Instant.now().plus(2, ChronoUnit.HOURS)
                )
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}
