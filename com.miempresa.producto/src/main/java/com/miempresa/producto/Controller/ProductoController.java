package com.miempresa.producto.Controller;


import java.util.List;
import java.util.Optional;
import com.miempresa.producto.Entity.Producto;
import com.miempresa.producto.IProductoService.IProductoService;

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
@RestController
@RequestMapping("/productos")
public class ProductoController  {
	@Autowired
	private IProductoService productoservice;
	
	@GetMapping
	public List<Producto> listaProducto(){
		return productoservice.getProducto();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerId(@PathVariable Long id){
		Optional<Producto> producto = productoservice.getProducto(id);
		return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoservice.postProducto(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){
		Producto productoActualizado = productoservice.putProducto(id, detalleProducto);
		if(productoActualizado != null) {
			return ResponseEntity.ok(productoActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
		productoservice.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}
