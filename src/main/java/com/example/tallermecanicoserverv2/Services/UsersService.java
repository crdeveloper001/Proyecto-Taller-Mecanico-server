package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.UsersDTO;
import com.example.tallermecanicoserverv2.Interfaces.IUsers;
import com.example.tallermecanicoserverv2.Repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsers {

    @Autowired
    private UsersRepositories service;

    public UsersService(UsersRepositories repo) {
        this.service = repo;
    }

    public UsersService() {
    }

    @Override
    public List<UsersDTO> GetUsers() {
        try {

            if (service.findAll().isEmpty()) {

                return null;

            } else {
                return service.findAll();
            }

        } catch (Exception errorGetList) {
            throw errorGetList;
        }
    }

    @Override
    public List<UsersDTO> SearchOneUsers(String Nombre) {
        try {

            if (Nombre == "") {

                return null;
            } else {
                return service.findUsersByName(Nombre);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddUsers(UsersDTO user) {
        try {
            if (user != null) {

                service.save(user);

                return "Usuario Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public UsersDTO UpdateUsers(UsersDTO update) {
        
        try{

            if (service.existsById(update.get_id())){
                service.save(update);

                return update;
            }else{
                return null;
            }

        }catch (Exception error){

            throw error;
        }
    }

    @Override
    public String DeleteUsers(int id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Usuario Eliminado";
            }else{

                return "Usuario no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
