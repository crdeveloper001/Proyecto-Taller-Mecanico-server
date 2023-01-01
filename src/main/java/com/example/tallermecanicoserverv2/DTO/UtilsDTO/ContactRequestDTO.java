package com.example.tallermecanicoserverv2.DTO.UtilsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "HistoryContactInfoWebSite")
public class ContactRequestDTO {

    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Apellidos")
    private String apellidos;
    @JsonProperty("Telefono")
    private int Telefono;
    @JsonProperty("CorreoElectronico")
    private String correoElectronico;

}
