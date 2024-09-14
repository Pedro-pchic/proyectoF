package com.miempresa.producto.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.producto.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
