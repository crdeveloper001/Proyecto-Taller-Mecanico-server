package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.Inventory.InventoryDTO;
import com.example.tallermecanicoserverv2.Interfaces.IInventory;
import com.example.tallermecanicoserverv2.Repositories.InventoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventory {

    @Autowired
    private InventoryRepositories service;

    public InventoryService(InventoryRepositories repo) {
        this.service = repo;
    }

    public InventoryService() {
    }

    @Override
    public List<InventoryDTO> GetInventory() {
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
    public List<InventoryDTO> SearchOneInventory(String Nombre) {

        try {

            if (Nombre == "") {

                return null;
            } else {
                return service.findItemByName(Nombre);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddInventory(InventoryDTO item) {
        try {
            if (item != null) {
                System.out.println(item);
                service.save(item);

                return "Item Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public InventoryDTO UpdateInventory(InventoryDTO update) {
        try {

            if (update.get_id() != null) {
                service.save(update);

                return update;
            } else {
                return null;
            }

        } catch (Exception error) {

            throw error;
        }
    }

    @Override
    public String DeleteInventory(int id) {
        try {

            if (service.existsById(id)) {

                service.deleteById(id);

                return "Item Eliminado";
            } else {

                return "Item no encontrado";
            }

        } catch (Exception errorDeleteShop) {

            return errorDeleteShop.getMessage();
        }
    }
}
