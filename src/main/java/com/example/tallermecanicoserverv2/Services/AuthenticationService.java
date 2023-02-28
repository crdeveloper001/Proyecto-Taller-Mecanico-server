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
    public String AuthUser(AuthenticationDTO credentiales) {

        List<UsersDTO> RegistroUsuariosList = new ArrayList<UsersDTO>();

        RegistroUsuariosList.add((UsersDTO) service.findAll());

        for (int i = 0; i < RegistroUsuariosList.size(); i++) {

            if (RegistroUsuariosList.get(i).getCorreoElectronico() == credentiales.getEmail() && RegistroUsuariosList.get(i).getClaveAcceso() == credentiales.getPassword()){
                return "Usuario Autenticado";

            }else{
                return "usuario incorrecto, vuelvalo a intentar";
            }
        }
        return "Ocurrio un error en el servidor, no se pudo autenticar";
    }
}
