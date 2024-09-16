 package com.miempresa.factura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private Long productoId;
    private int cantidad;
    private LocalDateTime fecha;

    public Factura(Long clienteId, Long productoId, int cantidad) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    public Factura() {
        // Constructor por defecto para JPA
    }
}

