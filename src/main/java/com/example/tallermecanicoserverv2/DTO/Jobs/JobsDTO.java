package com.example.tallermecanicoserverv2.DTO.Jobs;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.example.tallermecanicoserverv2.DTO.Vehicles.VehiclesDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@Document(collection = "Jobs")
public class JobsDTO {
    @JsonProperty("_id")
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
    @JsonProperty("ClientInformation")
    private ClientsDTO ClientInformation;

}
