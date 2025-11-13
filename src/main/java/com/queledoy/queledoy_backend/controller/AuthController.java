package com.queledoy.queledoy_backend.controller;
 
import com.queledoy.queledoy_backend.dto.AuthResponseDto;
import com.queledoy.queledoy_backend.dto.LoginRequestDto;
import com.queledoy.queledoy_backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/auth")
public class AuthController {
 
    @Autowired
    private AuthenticationManager authenticationManager;
 
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
 
 
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authenticateUser(@RequestBody LoginRequestDto loginRequest) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getCorreo(),
                        loginRequest.getContrasena()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}