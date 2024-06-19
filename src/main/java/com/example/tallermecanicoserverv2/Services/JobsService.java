package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.JobsDTO;
import com.example.tallermecanicoserverv2.Interfaces.IJobs;
import com.example.tallermecanicoserverv2.Repositories.JobsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class JobsService implements IJobs {

    @Autowired
    private JobsRepositories service;

    public JobsService(JobsRepositories repo) {
        this.service = repo;
    }

    public JobsService() {
    }

    @Override
    public List<JobsDTO> GetAllJobs() {
        try {

            if (service.findAll().isEmpty()) {

                return null;

            } else {
                return service.findAll();
            }

        } catch (Exception errorGetList) {
            throw errorGetList;
        }
    }

    @Override
    public List<JobsDTO> SearchOneJobByStatus(String jobStatus) {
        try {
            List<JobsDTO> currentJobs = service.findAll();
            List<JobsDTO> jobsByStatus = new ArrayList<>();
            if (jobStatus.isEmpty()) {
                return jobsByStatus;
            } else {
                for (JobsDTO currentJob : currentJobs) {
                    if (currentJob.getJob_Status().equalsIgnoreCase(jobStatus)) {
                        jobsByStatus.add(currentJob);
                    }
                }
            }
            return jobsByStatus;
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public String AddNewJob(JobsDTO jobDetails) {
        try {
            if (jobDetails != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                formatter.format(date) ;
                jobDetails.setJob_Start_Date(date);
                service.save(jobDetails);
                return "CREATED";

            } else {
                return "NOT CREATED";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public JobsDTO UpdateJobByStatus(JobsDTO update) {
        try{
            if (service.existsById(update.get_id())){
                service.save(update);
                return update;
            }else{
                return null;
            }

        }catch (Exception error){

            throw error;
        }
    }

    @Override
    public String DeleteJobById(String id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Job deleted successfully";
            }else{

                return "Job not found";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
