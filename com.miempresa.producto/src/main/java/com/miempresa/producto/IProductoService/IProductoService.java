package com.miempresa.producto.IProductoService;

import com.miempresa.producto.Entity.Producto;
import java.util.List;
import java.util.Optional;
public interface IProductoService {
	Producto postProducto(Producto producto);
	
	List<Producto> getProducto();
	
	Optional<Producto> getProducto(Long id);
	
	Producto putProducto(Long id, Producto producto);
	
	void deleteCliente(Long id);
}
