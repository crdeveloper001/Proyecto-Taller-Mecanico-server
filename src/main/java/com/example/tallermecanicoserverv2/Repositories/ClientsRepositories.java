package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.ClientsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepositories extends MongoRepository<ClientsDTO, Integer> {
    @Query("{nombre:'?0'}")
    List<ClientsDTO> findClientsByName(String name);


}
