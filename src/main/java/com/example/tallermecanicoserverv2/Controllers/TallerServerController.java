package com.example.tallermecanicoserverv2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class TallerServerController {

    @RequestMapping("/")
    @GetMapping()
    public ResponseEntity<?> Home(){
        return new ResponseEntity<>("<h1 style='text-align:center'>SERVER IS RUNNING<h1> <hr> ",HttpStatus.OK);
    }
    @RequestMapping("/status")
    @GetMapping()
    public ResponseEntity<?> getHealth() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("service", "TallerMecanico API");
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
    }
}
