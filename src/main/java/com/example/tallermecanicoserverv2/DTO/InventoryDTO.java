package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Inventory")
public class InventoryDTO {

    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Fabricante")
    private String Fabricante;
    @JsonProperty("Cantidad")
    private int Cantidad;
    @JsonProperty("Disponibilidad")
    private String Disponibilidad;
}
