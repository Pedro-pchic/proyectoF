package com.miempresa.factura.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miempresa.factura.Entity.Factura;
import com.miempresa.factura.Respository.FacturaRepository;
import com.miempresa.factura.Service.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // Crear una nueva factura
    @PostMapping
    public ResponseEntity<?> crearFactura(@RequestBody FacturaRepository request) {
        try {
            Factura factura = facturaService.crearFactura(
                request.getClienteId(), 
                request.getProductoId(), 
                request.getCantidad()
            );
            return new ResponseEntity<>(factura, HttpStatus.CREATED);
        } catch (ClienteNotFoundException e) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        } catch (ProductoNotFoundException e) {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la factura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> obtenerFacturas() {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        if (facturas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerFacturaPorId(@PathVariable Long id) {
        Optional<Factura> factura = facturaService.obtenerFacturaPorId(id);
        if (factura.isPresent()) {
            return new ResponseEntity<>(factura.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Factura no encontrada", HttpStatus.NOT_FOUND);
    }

    // Eliminar una factura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarFactura(@PathVariable Long id) {
        try {
            facturaService.eliminarFactura(id);
            return new ResponseEntity<>("Factura eliminada exitosamente", HttpStatus.OK);
        } catch (FacturaNotFoundException e) {
            return new ResponseEntity<>("Factura no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}

