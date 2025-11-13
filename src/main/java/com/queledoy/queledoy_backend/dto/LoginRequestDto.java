package com.queledoy.queledoy_backend.dto;
 
import lombok.Data;
 
@Data
public class LoginRequestDto {
    private String correo;
    private String contrasena;
}