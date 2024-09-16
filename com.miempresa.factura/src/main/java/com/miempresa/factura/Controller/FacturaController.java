package com.miempresa.factura.Controller;

import java.util.List;
import java.util.Optional;

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

import com.miempresa.factura.FacturaRequest.FacturaRequest;
import com.miempresa.factura.Service.FacturaService;
import com.miempresa.factura.entity.Factura;
import com.miempresa.factura.exception.ClienteNotFoundException;
import com.miempresa.factura.exception.ProductoNotFoundException;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaservice;
	
	@PostMapping 
	public ResponseEntity<?> crearFactura(@RequestBody FacturaRequest request){
			try {
				Factura factura = facturaservice.crearFactura(request.getClienteId(), request.getProductoId(), request.getCantidad());
				return new ResponseEntity<>(factura, HttpStatus.CREATED);
			
			}catch (ClienteNotFoundException | ProductoNotFoundException e){
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}catch (Exception e) {
				return new ResponseEntity<>("error al crear la factura ", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping 
	public ResponseEntity<List<Factura>> obtenerFacturas(){
		List<Factura> factura = facturaservice.obtenerTodasLasFacturas();
		return factura.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(factura, HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerfaacturasPorId(@PathVariable Long id){
		Optional<Factura> factura = facturaservice.obtenerFacturaPorId(id);
		return factura.isPresent() ? new ResponseEntity<>(factura.get(), HttpStatus.OK): new ResponseEntity<>("Factura no Encontrada ", HttpStatus.NOT_FOUND);
		
 	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarFactura(@PathVariable Long id){
		try {
			facturaservice.eliminarFactura(id);
			return new ResponseEntity<>("Factura elimanda exitosamente ", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Factura no Encotrada ", HttpStatus.NOT_FOUND);
		}
	}
	
	
}
