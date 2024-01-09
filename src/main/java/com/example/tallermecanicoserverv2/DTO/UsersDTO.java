package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Users")
public class UsersDTO {

    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Nombre")
    private String Nombre;
    @JsonProperty("Apellidos")
    private String Apellido;
    @JsonProperty("Telefono")
    private int Telefono;
    @JsonProperty("CorreoElectronico")
    private String CorreoElectronico;
    @JsonProperty("ClaveAcceso")
    private String ClaveAcceso;
    @JsonProperty("CargoActual")
    private String CargoActual;
    @JsonProperty("Rol")
    private String Rol;


}
