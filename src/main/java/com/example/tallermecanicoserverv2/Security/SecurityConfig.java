package com.example.tallermecanicoserverv2.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
* THIS FILE HAS THE CONFIGURATION FOR THE RECEPTION OF THE ENPOINTS AND PROTECT THEM FROM EXTERNAL REQUEST WITHOUT AND
* AUTHORIZATION
* */
@Configuration
public class SecurityConfig  {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passEncoder().encode("testpassword"))
                .roles()
                .build());

        return manager;
    }

    @Bean
    AuthenticationManager authManagerService(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passEncoder())
                .and()
                .build();
    }
    //ENCRIPTA LA CLAVE DE ACCESO PREVIAMENTE ESTABLECIDA EN EL BEAN DE USUARIO
    @Bean
    PasswordEncoder passEncoder(){
        return new BCryptPasswordEncoder();
    }


}

