package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.AuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.UsersDTO;
import com.example.tallermecanicoserverv2.Interfaces.IAuthentication;
import com.example.tallermecanicoserverv2.Repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements IAuthentication {
    @Autowired
    private UsersRepositories service;
    @Override
    public String AuthUser(AuthenticationDTO credentials) {

        List<UsersDTO> registroUsuariosList = service.findAll();

        for (UsersDTO user : registroUsuariosList) {
            if (user.getCorreoElectronico().equals(credentials.getEmail()) &&
                    user.getClaveAcceso().equals(credentials.getPassword())) {
                return "Authorized";
            }
        }

        return "Unauthorized";
    }
}
