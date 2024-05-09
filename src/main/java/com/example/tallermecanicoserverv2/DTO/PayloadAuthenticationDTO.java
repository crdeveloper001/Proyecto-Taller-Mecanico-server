package com.example.tallermecanicoserverv2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayloadAuthenticationDTO {
    private String Auth_key;
    private UsersDTO payload;
}
