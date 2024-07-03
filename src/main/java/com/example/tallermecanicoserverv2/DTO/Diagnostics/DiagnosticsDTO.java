package com.example.tallermecanicoserverv2.DTO.Diagnostics;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ReplacementDTO;
import com.example.tallermecanicoserverv2.DTO.Vehicles.VehiclesDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Diagnostics")
public class DiagnosticsDTO {

    @JsonProperty("_id")
    private int _id;

    @JsonProperty("DiagnosisType")
    private String diagnosisType;

    @JsonProperty("ClientDetails")
    private ClientsDTO clientName;

    @JsonProperty("VehicleDetails")
    private VehiclesDTO vehicleDetails;

    @JsonProperty("RepairDetails")
    private String repairDetails;

    @JsonProperty("RequiredParts")
    private ReplacementDTO requiredParts;

}
