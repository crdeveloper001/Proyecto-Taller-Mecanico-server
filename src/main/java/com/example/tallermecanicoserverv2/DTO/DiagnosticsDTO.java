package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Diagnostics")
public class DiagnosticsDTO {

    @JsonProperty("_id")
    private int _id;
    @JsonProperty("TipoDiagnostico")
    private String TipoDiagnostico;
    @JsonProperty("DatosVehiculo")
    private VehiclesDTO DatosVehiculo;
    @JsonProperty("EvaluacionAdjunta")
    private String EvaluacionAdjunta;
    @JsonProperty("CorreoCliente")
    private String CorreoCliente;
}
