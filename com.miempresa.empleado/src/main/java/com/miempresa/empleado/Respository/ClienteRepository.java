package com.miempresa.empleado.Respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miempresa.empleado.Entity.Empleado;
@Repository
public interface ClienteRepository extends JpaRepository<Empleado, Long> {

}

