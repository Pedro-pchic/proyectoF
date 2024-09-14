package com.miempresa.factura.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.miempresa.producto.Entity.Producto;

@FeignClient(name = "producto-service", url="http://localhost:8084/productos")
public interface ProductoClient {
	@GetMapping("/{id}")
	Producto obtenerId(@PathVariable("id")Long id);
}
