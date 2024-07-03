package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.Inventory.InventoryDTO;

import java.util.List;

public interface IInventory {
    List<InventoryDTO> GetInventory();
    List<InventoryDTO> SearchOneInventory(String name);
    String AddInventory(InventoryDTO item);
    InventoryDTO UpdateInventory(InventoryDTO update);
    String DeleteInventory(int id);
}
