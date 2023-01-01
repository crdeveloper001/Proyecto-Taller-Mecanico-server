package com.example.tallermecanicoserverv2.Controllers;


import com.example.tallermecanicoserverv2.DTO.VehiclesDTO;
import com.example.tallermecanicoserverv2.Services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Vehicles")
public class VehiclesController {

    @Autowired
    private VehiclesService service;

    @GetMapping()
    public List<VehiclesDTO> GetClients() {
        return service.GetVehicles();
    }

    @GetMapping("/Search/{Marca}")
    public List<VehiclesDTO> Search(@PathVariable String Marca) {
        return service.SearchOneVehicles(Marca);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostVehicles(@RequestBody VehiclesDTO client) {
        return new ResponseEntity<>(service.AddVehicles(client), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutVehicles(@RequestBody VehiclesDTO update) {
        return new ResponseEntity<>(service.UpdateVehicles(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteVehicles(@PathVariable int id) {
        return service.DeleteVehicles(id);
    }
}
