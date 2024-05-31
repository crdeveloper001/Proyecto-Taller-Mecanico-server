package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.ClientsDTO;
import com.example.tallermecanicoserverv2.Interfaces.IClients;
import com.example.tallermecanicoserverv2.Repositories.ClientsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ClientsDTO SearchOneClient(String name) {

        try {
            List<ClientsDTO> clients = service.findAll();
            
            for (ClientsDTO client : clients) {
                if (client.getName().equalsIgnoreCase(name)) {
                    return client;
                }else{
                    return null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
           
        }

        return null;
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
