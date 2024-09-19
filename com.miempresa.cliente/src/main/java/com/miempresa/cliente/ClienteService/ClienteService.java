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

	@Override
	public Cliente save(Cliente cliente) {
		Cliente newCliente = clienteRepository.save(cliente);
		return newCliente;
	}

	@Override
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente update(Long id, Cliente detallescliente) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente clienteExistente = clienteOptional.get();
			clienteExistente.setNombre(detallescliente.getNombre());
			clienteExistente.setCorreo(detallescliente.getCorreo());
			clienteExistente.setTelefono(detallescliente.getTelefono());
			return clienteRepository.save(clienteExistente);
		}else {
			return null; 
		} 
	}

	@Override
	public void deleteById(Long id) {
		 clienteRepository.deleteById(id);
	}
	
}
