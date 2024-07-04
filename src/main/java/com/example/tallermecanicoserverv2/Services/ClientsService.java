package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.example.tallermecanicoserverv2.Interfaces.IClients;
import com.example.tallermecanicoserverv2.Repositories.ClientsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<ClientsDTO> matchedClients = new ArrayList<>();

        try {
            List<ClientsDTO> clients = service.findAll();

            for (ClientsDTO client : clients) {
                if (client.getName().toLowerCase().contains(name.toLowerCase())) {
                    matchedClients.add(client);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchedClients;
    }


    @Override
    public String AddClient(ClientsDTO client) {

        List<ClientsDTO> current_Clients = service.findAll();

        try {
            if ((client.get_id() != 0) && (!client.getName().isEmpty())) {

                if(current_Clients.contains(client)){
                    return "El cliente ya existe";
                }else{
                    service.save(client);
                    return "Cliente Agregado";
                }

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
