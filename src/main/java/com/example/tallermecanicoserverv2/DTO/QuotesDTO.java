package com.example.tallermecanicoserverv2.DTO;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.RepuestosDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Quotes")
public class QuotesDTO {

    @JsonProperty("_id")
    private int _id;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Details")
    private List<RepuestosDTO> Details;

    @JsonProperty("CurrentDate")
    private Date CurrentDate;
}
