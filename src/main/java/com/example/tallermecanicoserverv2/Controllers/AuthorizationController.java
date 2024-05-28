package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.AuthenticationDTO;
import com.example.tallermecanicoserverv2.DTO.PayloadAuthenticationDTO;
import com.example.tallermecanicoserverv2.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/Authorization")
public class AuthorizationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostAuthentication(@RequestBody AuthenticationDTO web_credentials) {

        PayloadAuthenticationDTO response = service.AuthUser(web_credentials);

        switch (response.getAuth_key()) {
            case "USER_AUTHORIZED":
                response.getPayload().setPassword("");
                return new ResponseEntity<PayloadAuthenticationDTO>(response, HttpStatus.OK);

            case "USER_NOT_FOUND":
                return new ResponseEntity<PayloadAuthenticationDTO>(response, HttpStatus.NOT_FOUND);

        }
        return null;

    }
}
