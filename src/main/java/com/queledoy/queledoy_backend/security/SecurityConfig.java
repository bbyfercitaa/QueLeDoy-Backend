package com.queledoy.queledoy_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilita CORS
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF (común en APIs REST)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // API sin estado
            .authorizeHttpRequests(authz -> authz
                // --- Endpoints Públicos ---
                .requestMatchers("/api/auth/**").permitAll() // Login y Registro
                .requestMatchers(HttpMethod.GET, "/api/productos/**").permitAll() // Ver productos
                
                // --- Endpoints de Admin ---
                .requestMatchers(HttpMethod.POST, "/api/productos").hasAuthority("ADMIN") // Crear producto
                .requestMatchers(HttpMethod.PUT, "/api/productos/**").hasAuthority("ADMIN") // Actualizar producto
                .requestMatchers(HttpMethod.DELETE, "/api/productos/**").hasAuthority("ADMIN") // Borrar producto

                // --- Endpoints de Usuario ---
                // .requestMatchers("/api/pedidos/**").hasAuthority("USER") // (Ejemplo para cuando lo crees)

                // --- El resto requiere autenticación ---
                .anyRequest().authenticated()
            );

        // Añade nuestro filtro JWT antes del filtro de username/password
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean para que Spring pueda manejar la autenticación
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Bean para encriptar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean para la configuración de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // AQUI PONES LA URL DE TU FRONTEND EN VERCEL
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173", "https://tu-frontend.vercel.app"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}