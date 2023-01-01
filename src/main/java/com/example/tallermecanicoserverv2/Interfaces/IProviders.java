package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.ProvidersDTO;

import java.util.List;

public interface IProviders {
    List<ProvidersDTO> GetProviders();
    List<ProvidersDTO> SearchOneProviders(String name);
    String AddProviders(ProvidersDTO inventory);
    ProvidersDTO UpdateProviders(ProvidersDTO update);
    String DeleteProviders(int id);
}
