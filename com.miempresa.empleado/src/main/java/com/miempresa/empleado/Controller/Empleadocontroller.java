package com.miempresa.empleado.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
import com.miempresa.empleado.Entity.Empleado;
import com.miempresa.empleado.IClienteServuce.IClienteService;
@RestController
@RequestMapping("/empleados")
public class Empleadocontroller {

	@Autowired
	private IClienteService empleadoService;
	
	@GetMapping
	public List<Empleado> listaEmpleado(){
		return empleadoService.getEmpleado();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerId(@PathVariable Long id){
		Optional<Empleado> empleado = empleadoService.getEmpleadoId(id);
		return empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Empleado crearEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.postEmpleado(empleado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detalleEmpleado){
		Empleado empleadoActualizado = empleadoService.putEmpleado(id, detalleEmpleado);
		if(empleadoActualizado != null) {
			return ResponseEntity.ok(empleadoActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
		empleadoService.deleteEmpleado(id);
		return ResponseEntity.noContent().build();
	}
}
