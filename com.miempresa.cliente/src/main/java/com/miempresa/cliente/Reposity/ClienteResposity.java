package com.miempresa.cliente.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miempresa.cliente.Entity.Cliente;

@Repository //conexion a la base de datos respositorio
public interface ClienteResposity extends JpaRepository<Cliente, Long> {
	
}
