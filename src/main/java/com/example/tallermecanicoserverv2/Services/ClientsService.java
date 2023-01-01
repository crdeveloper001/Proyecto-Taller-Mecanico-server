package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.ClientsDTO;
import com.example.tallermecanicoserverv2.Interfaces.IClients;
import com.example.tallermecanicoserverv2.Repositories.ClientsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService implements IClients {

    @Autowired
    private ClientsRepositories service;

    public ClientsService(ClientsRepositories repo) {
        this.service = repo;
    }

    public ClientsService() {
    }

    @Override
    public List<ClientsDTO> GetClients() {
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
    public List<ClientsDTO> SearchOneClient(String name) {

        try {

            if (service.findClientsByName(name).isEmpty()) {

                return null;
            } else {
                return service.findClientsByName(name);
            }

        } catch (Exception e) {
            //test
            throw e;
        }
    }

    @Override
    public String AddClient(ClientsDTO client) {

        try {
            if (client.get_id() != 0 && client.getNombre() != "") {

                service.save(client);

                return "Cliente Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public ClientsDTO UpdateClient(ClientsDTO update) {

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
    public String DeleteClient(int cedula) {

        try{

            if (service.existsById(cedula)){

                service.deleteById(cedula);

                return "Cliente Eliminado";
            }else{

                return "Cliente no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }


    }
}
