package com.prueba_clm.PruebaCLM.service;

import com.prueba_clm.PruebaCLM.dto.ProductoDTO;
import com.prueba_clm.PruebaCLM.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {
    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto);
    void eliminarSucursal(Long id);
}
