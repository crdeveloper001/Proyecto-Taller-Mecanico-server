package com.example.tallermecanicoserverv2.Controllers;

import com.example.tallermecanicoserverv2.DTO.DiagnosticsDTO;
import com.example.tallermecanicoserverv2.Services.DiagnosticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/v1/Diagnostics")
public class DiagnosticsController {


    @Autowired
    private DiagnosticsService service;

    @GetMapping()
    public List<DiagnosticsDTO> GetDiagnostics() {

        return service.GetDiagnostics();
    }

    @GetMapping("Search/{TipoDiagnostico}")
    public List<DiagnosticsDTO> Search(@PathVariable String TipoDiagnostico) {
        return service.SearchOneDiagnostics(TipoDiagnostico);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostDiagnostics(@RequestBody DiagnosticsDTO info) {
        return new ResponseEntity<>(service.AddDiagnostics(info), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> PutDiagnostics(@RequestBody DiagnosticsDTO update) {
        return new ResponseEntity<>(service.UpdateDiagnostics(update), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String DeleteDiagnostics(@PathVariable int id) {
        return service.DeleteDiagnostics(id);
    }
}
