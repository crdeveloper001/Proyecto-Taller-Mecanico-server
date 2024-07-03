package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.Providers.ProvidersDTO;
import com.example.tallermecanicoserverv2.Services.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/Providers")
public class ProvidersController {

    @Autowired
    private ProvidersService service;

    @GetMapping()
    public List<ProvidersDTO> GetClients() {
        return service.GetProviders();
    }

    @GetMapping("/Search/{Nombre}")
    public List<ProvidersDTO> Search(@PathVariable String Nombre) {
        return service.SearchOneProviders(Nombre);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostProviders(@RequestBody ProvidersDTO client) {
        return new ResponseEntity<>(service.AddProviders(client), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutProviders(@RequestBody ProvidersDTO update) {
        return new ResponseEntity<>(service.UpdateProviders(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteProviders(@PathVariable int id) {
        return service.DeleteProviders(id);
    }

}
