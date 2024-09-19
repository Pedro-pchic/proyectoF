package com.miempresa.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.miempresa.producto.Entity.Producto;

@FeignClient(name = "producto-service", url = "http://localhost:8084/productos")
public interface ProductoFeignClient {
	@GetMapping("productos/{id}")
	Producto obtenerId(@PathVariable("id") Long id);
}
