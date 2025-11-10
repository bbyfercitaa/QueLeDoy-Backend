package com.queledoy.queledoy_backend.security;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
 
import javax.crypto.SecretKey;
import java.util.Date;
 
@Component
public class JwtTokenProvider {
 
    @Value("${app.jwt-secret}") // Lo pondremos en application.properties
    private String jwtSecret;
 
    @Value("${app.jwt-expiration-milliseconds}") // Lo pondremos en application.properties
    private long jwtExpirationDate;
 
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
 
    // Genera el token
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + jwtExpirationDate);
 
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(getKey())
                .compact();
    }
 
    // Obtiene el username (correo) desde el token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
 
    // Valida el token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parse(token);
            return true;
        } catch (Exception ex) {
            // Aquí puedes manejar diferentes excepciones (token expirado, malformado, etc.)
            return false;
        }
    }
}