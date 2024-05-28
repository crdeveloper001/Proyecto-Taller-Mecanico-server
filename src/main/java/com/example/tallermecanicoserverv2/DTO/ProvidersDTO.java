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

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Phone")
    private int phone;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("PartsType")
    private String partsType;

}
