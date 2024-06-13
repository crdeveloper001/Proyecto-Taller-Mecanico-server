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
public class ReplacementDTO {

    @JsonProperty("Part")
    private String part;
    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Price")
    private int price;

}
