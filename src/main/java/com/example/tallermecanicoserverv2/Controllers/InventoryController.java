package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.InventoryDTO;
import com.example.tallermecanicoserverv2.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping()
    public List<InventoryDTO> GetClients() {

        return service.GetInventory();
    }

    @GetMapping("/Search/{Nombre}")
    public List<InventoryDTO> Search(@PathVariable String Nombre) {
        return service.SearchOneInventory(Nombre);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostInventory(@RequestBody InventoryDTO info) {
        return new ResponseEntity<>(service.AddInventory(info), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutInventory(@RequestBody InventoryDTO update) {
        return new ResponseEntity<>(service.UpdateInventory(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteInventory(@PathVariable int id) {
        return service.DeleteInventory(id);
    }
}
