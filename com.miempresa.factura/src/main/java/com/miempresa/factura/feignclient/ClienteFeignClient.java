package com.miempresa.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.miempresa.cliente.Entity.Cliente;

@FeignClient(name ="cliente-service", url ="http://localhost:8082")
public interface ClienteFeignClient {
	@GetMapping("/clientes/{id}")
	Cliente getClienteById(@PathVariable("id") Long id);
}
