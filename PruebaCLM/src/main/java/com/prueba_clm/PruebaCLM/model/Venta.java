package com.prueba_clm.PruebaCLM.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String estado;

    @ManyToOne   //Muchos a uno. Pueden haber muchas ventas para una sucursal.
    private Sucursal sucursal;

    @OneToMany (mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)  //fetch = FetchType.EAGER hace que el detalle siempre lo traiga
    private List<DetalleVenta> detalle = new ArrayList<>();

    private Double total;
}
