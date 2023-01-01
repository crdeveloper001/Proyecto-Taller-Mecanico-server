package com.example.tallermecanicoserverv2.DTO;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.RepuestosDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Quotes")
public class QuotesDTO {


    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Tipo")
    private String Tipo;
    @JsonProperty("Cliente")
    private String Cliente;
    @JsonProperty("Apellidos")
    private String Apellidos;
    @JsonProperty("Correo")
    private String Correo;
    @JsonProperty("Detalles")
    private RepuestosDTO Detalles;
    @JsonProperty("Fecha")
    private Date Fecha;
}
