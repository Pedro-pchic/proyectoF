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
import com.miempresa.proveedor.ServiceProveedor.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor){
		return ResponseEntity.ok(proveedorService.save(proveedor));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Proveedor>> findAll(){
		return ResponseEntity.ok(proveedorService.findAll());
	}
	
	@GetMapping("obtenerId/{id}")
	public ResponseEntity<Proveedor> findById(@PathVariable Long id){
			Optional<Proveedor> proveedor = proveedorService.findById(id);
			return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Proveedor> update(@PathVariable Long id,@RequestBody Proveedor detalleproveedor){
		Proveedor proveedorActualizado = proveedorService.update(id, detalleproveedor);
		if( proveedorActualizado != null) {
			return ResponseEntity.ok(proveedorActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		proveedorService.deleteById(id);
		return ResponseEntity.noContent().build();
	
	}
	
}
