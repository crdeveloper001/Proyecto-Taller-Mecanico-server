package com.example.tallermecanicoserverv2.DTO.UtilsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "HistoryContactInfoWebSite")
public class ContactRequestDTO {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Surnames")
    private String surnames;
    @JsonProperty("Phone")
    private int phone;
    @JsonProperty("Email")
    private String email;


}
