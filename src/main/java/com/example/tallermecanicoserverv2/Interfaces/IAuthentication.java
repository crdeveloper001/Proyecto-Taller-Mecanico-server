package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.Authorization.AuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.Authorization.PayloadAuthenticationDTO;

public interface IAuthentication {

    PayloadAuthenticationDTO AuthUser(AuthenticationDTO credentials);
}
