package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.Diagnostics.DiagnosticsDTO;
import com.example.tallermecanicoserverv2.Interfaces.IDiagnostics;
import com.example.tallermecanicoserverv2.Repositories.DiagnosticsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticsService implements IDiagnostics {

    @Autowired
    private DiagnosticsRepositories service;

    public DiagnosticsService(DiagnosticsRepositories repo) {
        this.service = repo;
    }

    public DiagnosticsService() {
    }

    @Override
    public List<DiagnosticsDTO> GetDiagnostics() {
        try {

            if (service.findAll().isEmpty()) {

                return null;

            } else {
                return service.findAll();
            }

        } catch (Exception errorGetList) {
            throw errorGetList;
        }
    }

    @Override
    public List<DiagnosticsDTO> SearchOneDiagnostics(String TipoDiagnostico) {
        try {

            if (TipoDiagnostico == "")  {

                return null;
            } else {
                return service.findDiagnosticByName(TipoDiagnostico);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddDiagnostics(DiagnosticsDTO diagnostics) {
        try {
            if (diagnostics != null) {

                service.save(diagnostics);

                return "Diagnostico Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public DiagnosticsDTO UpdateDiagnostics(DiagnosticsDTO update) {
        try{

            if (service.existsById(update.get_id())){
                service.save(update);

                return update;
            }else{
                return null;
            }

        }catch (Exception error){

            throw error;
        }
    }

    @Override
    public String DeleteDiagnostics(int id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Diagnostico Eliminado";
            }else{

                return "Registro no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
