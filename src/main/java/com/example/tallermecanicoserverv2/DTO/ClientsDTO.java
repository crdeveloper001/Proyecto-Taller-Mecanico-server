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
    private String name;
    @JsonProperty("Surname")
    private String surname;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Phone")
    private int phone;
    @JsonProperty("CurrentAddress")
    private String currentAddress;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Zipcode")
    private int zipcode;
}
