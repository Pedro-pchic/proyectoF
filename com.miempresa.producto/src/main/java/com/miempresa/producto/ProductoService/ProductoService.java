package com.miempresa.producto.ProductoService;

import com.miempresa.producto.IProductoService.IProductoService;

import com.miempresa.producto.Entity.Producto;
import com.miempresa.producto.Repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService implements IProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto postProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> getProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> getProducto(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public Producto putProducto(Long id, Producto detalleproducto) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
		if(productoOptional.isPresent()) {
			Producto productoExistente = productoOptional.get();
			productoExistente.setNombre(detalleproducto.getNombre());
			productoExistente.setPrecio(detalleproducto.getPrecio());
			productoExistente.setStock(detalleproducto.getStock());
			return productoRepository.save(productoExistente);
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteCliente(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

}
