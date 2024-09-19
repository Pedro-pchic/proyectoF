package com.miempresa.producto.ProductoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.producto.Entity.Producto;
import com.miempresa.producto.Repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> obtenerTodosLosProductos(){
		return productoRepository.findAll();

	}
	
	public Optional<Producto> obtenerProductoPorId(Long id){
		return productoRepository.findById(id);
	
	}
	
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}
}
