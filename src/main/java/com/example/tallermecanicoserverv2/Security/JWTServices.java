package com.example.tallermecanicoserverv2.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTServices {
    private final static String ACCESS_TOKEN_SECRET = "2jopspsdmnfjj445oknsaHfffj455";
    private final static Long ACCESS_TOKEN_EXPIRATION = 2_592_000L;

    //Generate el token de autorizacion para los usuarios entrantes al sistema
    public static String TokenCreationService(String UserName,String UserEmail){
        long expirationTIme = ACCESS_TOKEN_EXPIRATION * 1000;
        Date expirtationDate = new Date(System.currentTimeMillis() + expirationTIme);

        Map<String,Object> extra = new HashMap<>();
        extra.put("nombre",UserName);

        return Jwts.builder()
                .setSubject(UserEmail)
                .setExpiration(expirtationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.ES512,ACCESS_TOKEN_SECRET.getBytes())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken TokenValidationService(String token){
        try{

            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());

        }catch (JwtException errorValidation){
            return null;
        }
    }
}
