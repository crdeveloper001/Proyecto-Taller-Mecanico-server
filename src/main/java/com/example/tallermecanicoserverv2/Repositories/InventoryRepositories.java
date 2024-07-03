package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.Inventory.InventoryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface InventoryRepositories extends MongoRepository<InventoryDTO, Integer> {
    @Query("{Nombre:'?0'}")
    List<InventoryDTO> findItemByName(String name);

}
