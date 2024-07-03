package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.Jobs.JobsDTO;
import com.example.tallermecanicoserverv2.Services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/Jobs")
public class JobsController {

    @Autowired
    private JobsService service;

    @GetMapping
    public List<JobsDTO> getAllJobs() {
        return service.GetAllJobs();
    }

    @GetMapping("/Search/{status}")
    public List<JobsDTO> getJobsByStatus(@PathVariable String status) {
        return service.SearchOneJobByStatus(status);

    }

    @PostMapping()
    public ResponseEntity<?> addJob(@RequestBody JobsDTO new_job) {

        switch (service.AddNewJob(new_job)) {
            case "CREATED":
                return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
            case "NOT_CREATED":
                return new ResponseEntity<>("NOT_CREATED", HttpStatus.CONFLICT);
            default:
                return new ResponseEntity<>("BAD_RESPONSE", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<?> updateJob(@RequestBody JobsDTO update) {

        switch (update.getJob_Status()) {
            case "In Progress":
                update.setJob_Status("In Progress");
                service.UpdateJobByStatus(update);
                return new ResponseEntity<>("Job " + update.get_id() + " Moved to In Progress", HttpStatus.OK);

            case "Completed":
                update.setJob_Status("Completed");
                service.UpdateJobByStatus(update);
                return new ResponseEntity<>("Job " + update.get_id() + " Moved to Completed", HttpStatus.OK);
            default:
                return new ResponseEntity<>("An error occur for update this job", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/Delete/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable String jobId) {
        return new ResponseEntity<>(service.DeleteJobById(jobId), HttpStatus.OK);
    }
}
