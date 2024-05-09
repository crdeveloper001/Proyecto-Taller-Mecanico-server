package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.AuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.PayloadAuthenticationDTO;

public interface IAuthentication {

    PayloadAuthenticationDTO AuthUser(AuthenticationDTO credentials);
}
