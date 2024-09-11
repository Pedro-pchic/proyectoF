package com.miempresa.cliente.Controller;


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

import com.miempresa.cliente.Entity.Cliente;
import com.miempresa.cliente.IClienteService.IClienteService;
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	//lista Cliente
	@GetMapping
	public List<Cliente> listaCliente(){
		return clienteService.getCliente();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerId(@PathVariable Long id){
		Optional<Cliente> cliente = clienteService.getClienteId(id);
		return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return clienteService.postCliente(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente detallesCliente){
		Cliente clienteActualizado = clienteService.putCliente(id, detallesCliente);
		if( clienteActualizado != null) {
			return ResponseEntity.ok(clienteActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	
}

