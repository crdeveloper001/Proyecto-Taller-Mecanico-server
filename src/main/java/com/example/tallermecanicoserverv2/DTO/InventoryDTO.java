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

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Manufacturer")
    private String manufacturer;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("Availability")
    private String availability;

}
