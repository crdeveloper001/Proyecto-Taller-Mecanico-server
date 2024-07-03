package com.example.tallermecanicoserverv2.Repositories;

import com.example.tallermecanicoserverv2.DTO.Jobs.JobsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository()
public interface JobsRepositories extends MongoRepository<JobsDTO, String> {
    @Query("{job_Name:'?0'}")
    List<JobsDTO> findJobByName(String job_Name);
}
