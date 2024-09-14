package com.miempresa.factura.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.factura.Entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
