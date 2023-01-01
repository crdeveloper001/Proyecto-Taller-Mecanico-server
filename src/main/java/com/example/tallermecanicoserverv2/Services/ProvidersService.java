package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.ProvidersDTO;
import com.example.tallermecanicoserverv2.Interfaces.IProviders;
import com.example.tallermecanicoserverv2.Repositories.ProvidersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidersService implements IProviders {

    @Autowired
    private ProvidersRepositories service;

    public ProvidersService(ProvidersRepositories repo) {
        this.service = repo;
    }

    public ProvidersService() {
    }


    @Override
    public List<ProvidersDTO> GetProviders() {
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
    public List<ProvidersDTO> SearchOneProviders(String Nombre) {
        try {

            if (Nombre == "") {

                return null;
            } else {
                return service.findProvidersByName(Nombre);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddProviders(ProvidersDTO provider) {
        try {
            if (provider != null) {

                service.save(provider);

                return "Proveedor Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public ProvidersDTO UpdateProviders(ProvidersDTO update) {
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
    public String DeleteProviders(int id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Proveedor Eliminado";
            }else{

                return "Proveedor no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
