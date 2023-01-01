package com.example.tallermecanicoserverv2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class TallerServerController {

    @RequestMapping("/")
    @GetMapping()
    public ResponseEntity<?> Home(){
        return new ResponseEntity<>("<h1 style='text-align:center'>SERVER IS RUNNING<h1> <hr> ",HttpStatus.OK);
    }
}
