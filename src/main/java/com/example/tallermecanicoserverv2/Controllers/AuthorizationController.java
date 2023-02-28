package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.AuthenticationDTO;
import com.example.tallermecanicoserverv2.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Authorization")
public class AuthorizationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostAuthentication(@RequestBody AuthenticationDTO web_credentials){

        return new ResponseEntity<>(service.AuthUser(web_credentials), HttpStatus.OK);
    }
}
