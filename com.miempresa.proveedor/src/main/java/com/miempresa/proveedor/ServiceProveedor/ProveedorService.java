package com.miempresa.proveedor.ServiceProveedor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.proveedor.Entity.Proveedor;
import com.miempresa.proveedor.Repository.ProveedorRepository;
import com.miempresa.proveedor.Service.IProveedorService;

@Service
public class ProveedorService implements IProveedorService  {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	
	@Override
	public Proveedor postProveedor(Proveedor proveedor) {
			return proveedorRepository.save(proveedor);
	}

	@Override
	public List<Proveedor> getProveedro() {
		return proveedorRepository.findAll();
	}

	@Override
	public Optional<Proveedor> getProveedorId(Long id) {
		return proveedorRepository.findById(id);
	}

	@Override
	public Proveedor putProveedor(Long id, Proveedor detallesproveedor) {
		Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
		if(proveedorOptional.isPresent()) {
			Proveedor proveedorExistente = proveedorOptional.get();
			proveedorExistente.setNombre(detallesproveedor.getNombre());
			proveedorExistente.setDireccion(detallesproveedor.getDireccion());
			proveedorExistente.setTelefono(detallesproveedor.getTelefono());
			return proveedorRepository.save(proveedorExistente);
		}else {
			return null;
		}
	}

	@Override
	public void deleteProveedor(Long id) {
		proveedorRepository.deleteById(id);
		
	}

}
