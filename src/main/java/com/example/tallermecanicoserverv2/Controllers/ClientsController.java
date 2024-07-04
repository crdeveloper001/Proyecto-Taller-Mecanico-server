package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;
import com.example.tallermecanicoserverv2.Services.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/Clients")
public class ClientsController {

    private final ClientsService service;

    public ClientsController(ClientsService service) {
        this.service = service;
    }

    @GetMapping()
    public List<ClientsDTO> GetClients() {
        return service.GetClients();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name) {
        try {
            ClientsDTO result = service.SearchOneClient(name);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.FOUND);

            }else{
                return new ResponseEntity<>("NOT_FOUND", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the search.");
        }
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<String> PostClient(@RequestBody ClientsDTO client) {
        client.getVehicleDetails().set_id(client.get_id());
        return new ResponseEntity<>(service.AddClient(client), HttpStatus.OK);
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
