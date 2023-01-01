package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.VehiclesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface VehiclesRepositories extends MongoRepository<VehiclesDTO,Integer> {
    @Query("{Marca:'?0'}")
    List<VehiclesDTO> findByMarca(String Marca);

}
