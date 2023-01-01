package com.example.tallermecanicoserverv2.DTO;

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
    @JsonProperty("Marca")
    private String Marca;
    @JsonProperty("Tipo")
    private String Tipo;
    @JsonProperty("Cilindraje")
    private int Cilindraje;
    @JsonProperty("PlacaRegistral")
    private String PlacaRegistral;
    @JsonProperty("PropietarioActual")
    private ClientsDTO PropietarioActual;
    @JsonProperty("EstadoActual")
    private String EstadoActual;
}
