package com.example.tallermecanicoserverv2.DTO.Inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Inventory")
public class InventoryDTO {

    @JsonProperty("_id")
    private String _id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Manufacturer")
    private String manufacturer;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("Availability")
    private String availability;

    @JsonProperty("Provider")
    private String provider;

    @JsonProperty("ProviderContact")
    private String providerContact;
}
