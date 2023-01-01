package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.DiagnosticsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface DiagnosticsRepositories extends MongoRepository<DiagnosticsDTO, Integer> {
    @Query("{TipoDiagnostico:'?0'}")
    List<DiagnosticsDTO> findDiagnosticByName(String TipoDiagnostico);

}
