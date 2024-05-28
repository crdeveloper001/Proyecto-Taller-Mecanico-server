package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.QuotesDTO;
import com.example.tallermecanicoserverv2.Interfaces.IQuotes;
import com.example.tallermecanicoserverv2.Repositories.QuotesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuotesService implements IQuotes {


    @Autowired
    private QuotesRepositories service;

    public QuotesService(QuotesRepositories repo) {
        this.service = repo;
    }

    public QuotesService() {
    }
    @Override
    public List<QuotesDTO> GetQuotes() {
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
    public List<QuotesDTO> SearchOneQuotes(String Cliente) {
        try {

            if (Cliente == "") {

                return null;
            } else {
                return service.findQuotesByName(Cliente);
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public String AddQuotes(QuotesDTO quote) {
        try {
            if (quote != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date(); 
                formatter.format(date) ;
                quote.setCurrentDate(date);

                service.save(quote);

                return "Cotizacion Agregado";

            } else {
                return "Verifique los datos ingresados";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public QuotesDTO UpdateQuotes(QuotesDTO update) {
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
    public String DeleteQuotes(int id) {
        try{

            if (service.existsById(id)){

                service.deleteById(id);

                return "Cotizacion Eliminada";
            }else{

                return "Cotizacion no encontrado";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
