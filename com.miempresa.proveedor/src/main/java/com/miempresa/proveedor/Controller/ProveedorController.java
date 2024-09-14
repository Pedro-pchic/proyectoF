package com.miempresa.proveedor.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.proveedor.Entity.Proveedor;
import com.miempresa.proveedor.Service.IProveedorService;
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping
	public List<Proveedor> listaProveedor(){
		return proveedorService.getProveedro();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> obtenerId(@PathVariable Long id){
			Optional<Proveedor> proveedor = proveedorService.getProveedorId(id);
			return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Proveedor crearProveedor(@RequestBody Proveedor proveedor) { 
		return proveedorService.postProveedor(proveedor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id,@RequestBody Proveedor detalleproveedor){
		Proveedor proveedorActualizado = proveedorService.putProveedor(id, detalleproveedor);
		if( proveedorActualizado != null) {
			return ResponseEntity.ok(proveedorActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
		proveedorService.deleteProveedor(id);
		return ResponseEntity.noContent().build();
	
	}
	
}
