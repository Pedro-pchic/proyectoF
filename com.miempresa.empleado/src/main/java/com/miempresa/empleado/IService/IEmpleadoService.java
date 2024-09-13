package com.miempresa.empleado.IService;
import com.miempresa.empleado.Entity.Empleado;
import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
	//crear nuevo empleado
		Empleado postEmpleado(Empleado cliente);
		//obtener todo los empleado
		List<Empleado>getEmpleado();
		//obtener empleado por id
		
		Optional<Empleado> getEmmpleadoId(Long id);
		//actualizar empleado
		
		Empleado putCEmpleado(Long id, Empleado empleado);
		//eliminar empleado por id
		void deleteEmpleado(Long id);
		
}
