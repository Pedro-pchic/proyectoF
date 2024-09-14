package com.miempresa.proveedor.Service;


import java.util.Optional;
import java.util.List;
import com.miempresa.proveedor.Entity.Proveedor;
public interface IProveedorService {
	
	Proveedor postProveedor(Proveedor proveedor);
	List<Proveedor> getProveedro();
	Optional<Proveedor> getProveedorId(Long id);
	Proveedor putProveedor(Long id, Proveedor proveedor);
	void deleteProveedor(Long id);
}
