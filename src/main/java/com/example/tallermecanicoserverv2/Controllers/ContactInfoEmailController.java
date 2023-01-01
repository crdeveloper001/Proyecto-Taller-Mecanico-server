package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ContactRequestDTO;
import com.example.tallermecanicoserverv2.Services.ContactInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/ContactInfoMail")
public class ContactInfoEmailController {

    @Autowired
    private ContactInfoServices service;

    @GetMapping()
    public ResponseEntity<?>GetHistoryEmails(){

        return new ResponseEntity<>(service.GetHistoryRequests(), HttpStatus.OK);
    }
    @PostMapping()
    @ResponseBody()
    public ResponseEntity<?>PostEmailContact(@RequestBody ContactRequestDTO info){
        return new ResponseEntity<>(service.SendContactInfoEmail(info),HttpStatus.CREATED);
    }
}
