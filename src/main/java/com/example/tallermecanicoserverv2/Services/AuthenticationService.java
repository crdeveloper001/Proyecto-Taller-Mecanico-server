package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.AuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.PayloadAuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.UsersDTO;
import com.example.tallermecanicoserverv2.Interfaces.IAuthentication;
import com.example.tallermecanicoserverv2.Repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService implements IAuthentication {
    @Autowired
    private UsersRepositories service;

    @Override
    public PayloadAuthenticationDTO AuthUser(AuthenticationDTO credentials) {
        PayloadAuthenticationDTO currentPayload = new PayloadAuthenticationDTO();
        List<UsersDTO> registroUsuariosList = service.findAll();

        for (UsersDTO user : registroUsuariosList) {
            if (user.getEmail().equals(credentials.getEmail())
                    && user.getPassword().equals(credentials.getPassword())) {
                        
                currentPayload.setAuth_key("USER_AUTHORIZED");
                currentPayload.setPayload(user);
                return currentPayload;
            }
        }
        currentPayload.setAuth_key("USER_NOT_FOUND");
        currentPayload.setPayload(null);
        return currentPayload;

    }
}
