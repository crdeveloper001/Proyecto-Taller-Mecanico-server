package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Providers")
public class ProvidersDTO {

    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Nombre")
    private String Nombre;
    @JsonProperty("Telefono")
    private int Telefono;
    @JsonProperty("CorreoElectronico")
    private String CorreoElectronico;
    @JsonProperty("TipoRepuestos")
    private String TipoRepuestos;
}
