package com.example.tallermecanicoserverv2.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {

    @JsonProperty("User_Email")
    private String Email;
    @JsonProperty("User_Password")
    private String Password;
}
