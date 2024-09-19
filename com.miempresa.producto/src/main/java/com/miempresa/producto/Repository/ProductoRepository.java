package com.miempresa.producto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miempresa.producto.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
