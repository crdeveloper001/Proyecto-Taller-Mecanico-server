package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.ClientsDTO;
import com.example.tallermecanicoserverv2.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/Clients")
public class ClientsController {

    @Autowired
    private ClientsService service;

    @GetMapping()
    public List<ClientsDTO> GetClients() {
        return service.GetClients();
    }

    @GetMapping("{name}")
    public List<ClientsDTO> Search(@PathVariable String name) {
        return service.SearchOneClient(name);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostClient(@RequestBody ClientsDTO client) {
        return new ResponseEntity<>(service.AddClient(client), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutClient(@RequestBody ClientsDTO update) {
        return new ResponseEntity<>(service.UpdateClient(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{cedula}")
    public String DeleteClient(@PathVariable int cedula) {
        
        //int idConversion = Integer.parseInt(cedula);

        return service.DeleteClient(cedula);
    }

}
