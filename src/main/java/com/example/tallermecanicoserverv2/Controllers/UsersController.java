package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.Users.UsersDTO;
import com.example.tallermecanicoserverv2.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Users")
public class UsersController {
    @Autowired
    private UsersService service;

    @GetMapping()
    public List<UsersDTO> GetClients() {
        return service.GetUsers();
    }

    @GetMapping("/Search/{Nombre}")
    public List<UsersDTO> Search(@PathVariable String Nombre) {
        return service.SearchOneUsers(Nombre);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostUsers(@RequestBody UsersDTO client) {
        return new ResponseEntity<>(service.AddUsers(client), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutUsers(@RequestBody UsersDTO update) {
        return new ResponseEntity<>(service.UpdateUsers(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteUsers(@PathVariable int id) {
        return service.DeleteUsers(id);
    }
}
