package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayloadAuthenticationDTO {
    @JsonProperty("Auth_key")
    private String Auth_key;
    @JsonProperty("Payload")
    private UsersDTO Payload;
}
