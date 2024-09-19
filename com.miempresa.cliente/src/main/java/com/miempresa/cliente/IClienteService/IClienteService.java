package com.miempresa.cliente.IClienteService;

import com.miempresa.cliente.Entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
	//crear cliente 
	Cliente save(Cliente cliente);
	//obtener todo los clientes 
	List<Cliente> findAll();
	//obtener clients por id
	Optional<Cliente> findById(Long id);
	//actualizar cliente 
	Cliente update(Long id, Cliente cliente);
	//eliminar clientes por Id
	void deleteById(Long id);
	
}
