package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.Quotes.QuotesDTO;

import java.util.List;

public interface IQuotes {
    List<QuotesDTO> GetQuotes();
    List<QuotesDTO> SearchOneQuotes(String client);
    String AddQuotes(QuotesDTO quote);
    QuotesDTO UpdateQuotes(QuotesDTO update);
    String DeleteQuotes(int id);
}
