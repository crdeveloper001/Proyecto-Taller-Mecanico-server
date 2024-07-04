package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.ClientsInformation.ClientsDTO;

import java.util.List;

public interface IClients {

    List<ClientsDTO> GetClients();
    List<ClientsDTO> SearchOneClient(String name);
    String AddClient(ClientsDTO client);
    ClientsDTO UpdateClient(ClientsDTO update);
    String DeleteClient(int cedula);

}
