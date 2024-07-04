package com.example.tallermecanicoserverv2.DTO.Vehicles;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Vehicles")
public class VehiclesDTO {

    @JsonProperty("_id")
    private int _id;

    @JsonProperty("Brand")
    private String Brand;

    @JsonProperty("Model")
    private String Model;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("EngineCapacity")
    private int EngineCapacity;

    @JsonProperty("RegistrationPlate")
    private String RegistrationPlate;

}
