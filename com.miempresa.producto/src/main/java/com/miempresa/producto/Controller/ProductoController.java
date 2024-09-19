package com.miempresa.producto.Controller;


import java.util.List;
import java.util.Optional;
import com.miempresa.producto.Entity.Producto;
import com.miempresa.producto.ProductoService.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/productos")
public class ProductoController  {
	@Autowired
	private ProductoService productoService;
	
	//crear producto
	@PostMapping("/save")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		return ResponseEntity.ok(productoService.crearProducto(producto));
	}
	
	//obtener todos los productos 
	@GetMapping("/obtenerproducto")
	public List<Producto> obtenerTodoLosProductos(){
		return productoService.obtenerTodosLosProductos();
	}
	
	 @GetMapping("/obtener/{id}")
	    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
	        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
	        return producto.map(ResponseEntity::ok)
	                       .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Eliminar producto por ID
	    @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
	        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
	        if (producto.isPresent()) {
	            productoService.eliminarProducto(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
