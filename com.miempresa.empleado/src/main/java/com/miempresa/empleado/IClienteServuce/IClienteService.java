package com.miempresa.empleado.IClienteServuce;
import java.util.List;
import java.util.Optional;

import com.miempresa.empleado.Entity.Empleado;
public interface IClienteService {
	//crear empleado
	Empleado postEmpleado(Empleado empleado);
	//obtener todo los clientes
	List<Empleado> getEmpleado();
	//obtener clientes por id
	Optional<Empleado> getEmpleadoId(Long id);
	//actualizar clientes 
	Empleado putEmpleado(Long id, Empleado cliente);
	//eliminar empleado
	void deleteEmpleado(Long id);
	
}
