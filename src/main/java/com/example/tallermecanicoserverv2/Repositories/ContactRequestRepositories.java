package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ContactRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRequestRepositories extends MongoRepository<ContactRequestDTO, String> {
}
