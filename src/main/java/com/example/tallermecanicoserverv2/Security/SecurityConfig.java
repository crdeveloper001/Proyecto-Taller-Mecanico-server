package com.example.tallermecanicoserverv2.Security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.tallermecanicoserverv2.Security.ValidateJWT;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new ValidateJWT(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.POST, DispatcherType.valueOf("/AuthenticationServer")).permitAll()

                .anyRequest().permitAll();
    }
}

