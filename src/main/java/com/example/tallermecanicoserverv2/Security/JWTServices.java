package com.example.tallermecanicoserverv2.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTGenerator {
    private final static String ACCESS_TOKEN_SECRET = "2jopspsdmnfjj445oknsaHfffj455";
    private final static Long ACCESS_TOKEN_EXPIRATION = 2_592_000L;

    //Generate el token de autorizacion para los usuarios entrantes al sistema
    public static String createToken(String UserName,String UserEmail){
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

    public
}
