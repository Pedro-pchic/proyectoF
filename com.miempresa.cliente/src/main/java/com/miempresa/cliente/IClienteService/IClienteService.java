package com.miempresa.cliente.IClienteService;

import com.miempresa.cliente.Entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
	//crear cliente 
	Cliente postCliente(Cliente cliente);
	//obtener todo los clientes 
	List<Cliente> getCliente();
	//obtener clients por id
	Optional<Cliente> getClienteId(Long id);
	//actualizar cliente 
	Cliente putCliente(Long id, Cliente cliente);
	//eliminar clientes por Id
	void deleteCliente(Long id);
	
}
