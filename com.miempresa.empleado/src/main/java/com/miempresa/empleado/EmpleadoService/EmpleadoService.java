package com.miempresa.empleado.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.empleado.Entity.Empleado;
import com.miempresa.empleado.IClienteServuce.IClienteService;
import com.miempresa.empleado.Respository.EmpleadoRespository;
import java.util.Optional;
import java.util.List;
@Service
public class EmpleadoService implements IClienteService{
		@Autowired
		private EmpleadoRespository empleadoRespository;

		@Override
		public Empleado postEmpleado(Empleado empleado) {
			return empleadoRespository.save(empleado);
		}

		@Override
		public List<Empleado> getEmpleado() {
			return empleadoRespository.findAll();
		}
		@Override
		public Optional<Empleado> getEmpleadoId(Long id){
			
			return empleadoRespository.findById(id);
		}

		@Override
		public Empleado putEmpleado(Long id, Empleado detallesEmpleado) {
			Optional<Empleado> empleadoOptional = empleadoRespository.findById(id);
			if(empleadoOptional.isPresent()) {
				Empleado empleadoExistente = empleadoOptional.get();
				empleadoExistente.setNombre(detallesEmpleado.getNombre());
				empleadoExistente.setPuesto(detallesEmpleado.getPuesto());
				empleadoExistente.setSalario(detallesEmpleado.getSalario());
				return empleadoRespository.save(empleadoExistente);
			}else {
				return null;
			}
			
		}

		@Override
		public void deleteEmpleado(Long id) {
			empleadoRespository.deleteById(id);
		}
		
		
}
