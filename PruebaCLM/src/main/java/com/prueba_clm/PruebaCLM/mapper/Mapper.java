package com.prueba_clm.PruebaCLM.mapper;

import com.prueba_clm.PruebaCLM.dto.DetalleVentaDTO;
import com.prueba_clm.PruebaCLM.dto.ProductoDTO;
import com.prueba_clm.PruebaCLM.dto.SucursalDTO;
import com.prueba_clm.PruebaCLM.dto.VentaDTO;
import com.prueba_clm.PruebaCLM.model.Producto;
import com.prueba_clm.PruebaCLM.model.Sucursal;
import com.prueba_clm.PruebaCLM.model.Venta;
import com.prueba_clm.PruebaCLM.model.DetalleVenta;

import java.util.stream.Collectors;




public class Mapper {

    //Mapeo de producto a ProductoDTO
    public static ProductoDTO toDTO(Producto p){
        if (p == null) return null;
        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .cantidad(p.getCantidad())
                .build();
    }

    //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProd().getId())
                        .nombreProd(det.getProd().getNombre())
                        .cantProd(det.getCantProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .estado(venta.getEstado())
                .idSucursal(venta.getSucursal().getId())
                .detalle(detalle)
                .total(total)
                .build();
    }


    //Mapeo de Sucursal a SucursalDTO
    public static SucursalDTO toDTO(Sucursal s) {
        if (s == null) return null;
        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();
    }

}
