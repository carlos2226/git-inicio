package com.prueba_clm.PruebaCLM.service;

import com.prueba_clm.PruebaCLM.dto.ProductoDTO;
import com.prueba_clm.PruebaCLM.dto.VentaDTO;

import java.util.List;

public interface IVentaService {
    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(VentaDTO ventaDto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaDto);
    void eliminarVenta(Long id);
}
