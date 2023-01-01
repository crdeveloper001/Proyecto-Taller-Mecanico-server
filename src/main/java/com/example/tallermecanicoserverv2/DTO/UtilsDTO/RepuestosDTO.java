package com.example.tallermecanicoserverv2.DTO.UtilsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepuestosDTO {

    @JsonProperty("Repuesto")
    private String Repuesto;
    @JsonProperty("Cantidad")
    private int Cantidad;
    @JsonProperty("Precio")
    private int Precio;
}
