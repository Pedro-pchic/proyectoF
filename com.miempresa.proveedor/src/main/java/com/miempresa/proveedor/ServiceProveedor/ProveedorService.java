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
	public Proveedor save(Proveedor proveedor) {
			Proveedor newProveedor = proveedorRepository.save(proveedor);
			return newProveedor;
	}

	@Override
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}

	@Override
	public Optional<Proveedor> findById(Long id) {
		return proveedorRepository.findById(id);
	}

	@Override
	public Proveedor update(Long id, Proveedor detallesproveedor) {
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
	public void deleteById(Long id) {
		proveedorRepository.deleteById(id);
		
	}



}
