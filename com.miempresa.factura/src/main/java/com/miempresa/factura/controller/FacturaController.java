package com.miempresa.factura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.factura.entity.Factura;
import com.miempresa.factura.service.FacturaService;

import java.util.List;
@RestController
@RequestMapping("api/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
    // Crear una nueva factura
    @PostMapping("/save")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura facturaEntity) {
        Factura nuevaFactura = facturaService.crearFactura(facturaEntity);
        return ResponseEntity.ok(nuevaFactura);
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        Factura factura = facturaService.obtenerFacturaPorId(id);
        return ResponseEntity.ok(factura);
    }

    // Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        return ResponseEntity.ok(facturas);
    }

    // Eliminar una factura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
	
	
	
}
