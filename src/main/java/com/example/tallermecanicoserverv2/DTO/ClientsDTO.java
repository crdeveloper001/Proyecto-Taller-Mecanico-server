package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Clients")
public class ClientsDTO {

    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Name")
    private String nombre;
    @JsonProperty("Surname")
    private String apellidos;
    @JsonProperty("Email")
    private String correo;
    @JsonProperty("Phone")
    private int telefono;
    @JsonProperty("CurrentAddress")
    private String currentAddress;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Zipcode")
    private int zipcode;
}
