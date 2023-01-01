package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.VehiclesDTO;

import java.util.List;

public interface IVehicles {
    List<VehiclesDTO> GetVehicles();
    List<VehiclesDTO> SearchOneVehicles(String marca);
    String AddVehicles(VehiclesDTO user);
    VehiclesDTO UpdateVehicles(VehiclesDTO update);
    String DeleteVehicles(int id);
}
