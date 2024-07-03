package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.Vehicles.VehiclesDTO;
import com.example.tallermecanicoserverv2.Interfaces.IVehicles;
import com.example.tallermecanicoserverv2.Repositories.VehiclesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService implements IVehicles {

    @Autowired
    private VehiclesRepositories service;
    public VehiclesService(VehiclesRepositories repo) {
        this.service = repo;
    }
    public VehiclesService() {
    }
    @Override
    public List<VehiclesDTO> GetVehicles() {
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
    public List<VehiclesDTO> SearchOneVehicles(String Marca) {
        try {

            if (Marca == "") {

                return null;
            } else {
                return service.findByMarca(Marca);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddVehicles(VehiclesDTO vehicle) {
        try {
            if (vehicle != null) {
                service.save(vehicle);
                return "Vehiculo Agregado";
            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public VehiclesDTO UpdateVehicles(VehiclesDTO update) {
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
    public String DeleteVehicles(int id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Vehiculo Eliminado";
            }else{

                return "Vehiculo no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
