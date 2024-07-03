package com.example.tallermecanicoserverv2.DTO.Authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("Password")
    private String Password;
}
