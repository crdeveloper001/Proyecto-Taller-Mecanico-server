package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.Providers.ProvidersDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface ProvidersRepositories extends MongoRepository<ProvidersDTO, Integer> {
    @Query("{Nombre:'?0'}")
    List<ProvidersDTO> findProvidersByName(String Nombre);

}
