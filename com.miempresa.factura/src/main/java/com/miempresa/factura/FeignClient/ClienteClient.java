package com.miempresa.factura.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.miempresa.cliente.Entity.Cliente;

@FeignClient(name = "cliente-service", url = "http://localhost:8082/clientes")
public interface ClienteClient {

    @GetMapping("/{id}")
    Cliente obtenerClientePorId(@PathVariable("id") Long id);
}
