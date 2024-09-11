package com.miempresa.cliente.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.cliente.Entity.Cliente;
import com.miempresa.cliente.IClienteService.IClienteService;
import com.miempresa.cliente.Reposity.ClienteResposity;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{
	@Autowired //inveccion de pendencia de la inferca de clienteResposity
	private ClienteResposity clienteRepository;
		//crear cliente
	@Override
	public Cliente postCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
		//obtener clientes 
	@Override
	public List<Cliente> getCliente() {
		return clienteRepository.findAll();
	}
		//obtener clientes por Id
	@Override
	public Optional<Cliente> getClienteId(Long id) {
		return clienteRepository.findById(id);
	}
		//actualizar clientes existentes 
	@Override
	public Cliente putCliente(Long id, Cliente detallesCliente){
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente clienteExistente = clienteOptional.get();
			clienteExistente.setNombre(detallesCliente.getNombre());
			clienteExistente.setCorreo(detallesCliente.getCorreo());
			clienteExistente.setTelefono(detallesCliente.getTelefono());
			return clienteRepository.save(clienteExistente);
		}else {
			return null; 
		} 
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	
}
