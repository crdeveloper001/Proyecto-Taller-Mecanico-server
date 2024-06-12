package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.QuotesDTO;
import com.example.tallermecanicoserverv2.Services.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Quotes")
public class QuotesController {

    @Autowired
    private QuotesService service;

    @GetMapping()
    public List<QuotesDTO> GetClients() {
        return service.GetQuotes();
    }

    @GetMapping("/Search/{Cliente}")
    public List<QuotesDTO> Search(@PathVariable String cliente) {
        return service.SearchOneQuotes(cliente);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostQuotes(@RequestBody QuotesDTO client) {
       
        return new ResponseEntity<>(service.AddQuotes(client), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutQuotes(@RequestBody QuotesDTO update) {
        return new ResponseEntity<>(service.UpdateQuotes(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteQuotes(@PathVariable int id) {
        return service.DeleteQuotes(id);
    }
}
