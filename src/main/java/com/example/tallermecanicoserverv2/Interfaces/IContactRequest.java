package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ContactRequestDTO;

import java.util.List;

public interface IContactRequest {


    String SendContactInfoEmail(ContactRequestDTO request);
    String SaveContactInfoDB(ContactRequestDTO information);
    List<ContactRequestDTO> GetHistoryRequests();
}
