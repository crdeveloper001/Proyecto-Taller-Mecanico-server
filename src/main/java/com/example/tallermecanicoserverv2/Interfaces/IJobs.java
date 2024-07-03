package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.Jobs.JobsDTO;

import java.util.List;

public interface IJobs {

    List<JobsDTO> GetAllJobs();
    List<JobsDTO> SearchOneJobByStatus(String jobStatus);
    String AddNewJob(JobsDTO quote);
    JobsDTO UpdateJobByStatus(JobsDTO update);
    String DeleteJobById(String id);
}
