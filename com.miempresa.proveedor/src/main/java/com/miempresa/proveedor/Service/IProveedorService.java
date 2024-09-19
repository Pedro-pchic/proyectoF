package com.miempresa.proveedor.Service;


import java.util.Optional;
import java.util.List;
import com.miempresa.proveedor.Entity.Proveedor;
public interface IProveedorService {
	
	Proveedor save(Proveedor proveedor);
	List<Proveedor> findAll();
	Optional<Proveedor> findById(Long id);
	Proveedor update(Long id, Proveedor proveedor);
	void deleteById(Long id);
}
