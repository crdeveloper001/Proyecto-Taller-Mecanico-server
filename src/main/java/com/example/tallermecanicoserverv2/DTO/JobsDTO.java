package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class JobsDTO {

    @Id
    private String _id;
    @JsonProperty("job_Name")
    private String job_Name;

    @JsonProperty("job_Description")
    private String job_Description;
    @JsonProperty("job_Status")
    private String job_Status;
    @JsonProperty("job_Type")
    private String job_Type;
    @JsonProperty("job_Start_Date")
    private Date job_Start_Date;
    @JsonProperty("job_End_Date")
    @Null
    private Date job_End_Date;
    @JsonProperty("job_Location")
    private String job_Location;
    @JsonProperty("job_Assigned")
    private String job_Assigned;


}