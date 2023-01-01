package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.QuotesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface QuotesRepositories extends MongoRepository<QuotesDTO,Integer> {
    @Query("{Cliente:'?0'}")
    List<QuotesDTO> findQuotesByName(String Cliente);

}
