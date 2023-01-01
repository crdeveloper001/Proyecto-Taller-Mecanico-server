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
    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Apellidos")
    private String apellidos;
    @JsonProperty("Correo")
    private String correo;
    @JsonProperty("Telefono")
    private int telefono;


}
