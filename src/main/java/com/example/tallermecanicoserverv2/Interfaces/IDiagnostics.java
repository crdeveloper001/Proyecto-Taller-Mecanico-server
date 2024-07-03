package com.example.tallermecanicoserverv2.Interfaces;

import com.example.tallermecanicoserverv2.DTO.Diagnostics.DiagnosticsDTO;

import java.util.List;

public interface IDiagnostics {
    List<DiagnosticsDTO> GetDiagnostics();
    List<DiagnosticsDTO> SearchOneDiagnostics(String owner);
    String AddDiagnostics(DiagnosticsDTO diagnostics);
    DiagnosticsDTO UpdateDiagnostics(DiagnosticsDTO update);
    String DeleteDiagnostics(int id);
}
