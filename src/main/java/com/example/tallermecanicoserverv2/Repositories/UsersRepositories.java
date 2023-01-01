package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.UsersDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface UsersRepositories extends MongoRepository<UsersDTO,Integer> {
    @Query("{Nombre:'?0'}")
    List<UsersDTO> findUsersByName(String Nombre);

}
