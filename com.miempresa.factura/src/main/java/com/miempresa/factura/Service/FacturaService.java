package com.miempresa.factura.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.cliente.Entity.Cliente;
import com.miempresa.factura.Entity.Factura;
import com.miempresa.factura.FeignClient.ClienteClient;
import com.miempresa.factura.FeignClient.ProductoClient;
import com.miempresa.factura.Respository.FacturaRepository;
import com.miempresa.producto.Entity.Producto;
@Service
public class FacturaService {
	@Autowired
	private ProductoClient productoclient;
	
	@Autowired
	private ClienteClient clienteclient;
	
	@Autowired
	private FacturaRepository facturaRespository;
	
	public Factura crearFactura(Long clienteId, Long productoId, Integer cantidad) {
		 //obtener cliente
		Cliente cliente = clienteclient.obtenerId(clienteId);
		//obtener producto
		Producto producto = productoclient.obtenerId(productoId);
		//calcular el total de factura
		double total = producto.getPrecio() * cantidad;
		//crear la factura
		Factura factura = new Factura();
		factura.setClienteId(cliente.getId());
		factura.setProductoId(factura.getId());
		factura.setCantidad(cantidad);
		factura.setTotal(total);
		  
		//Guardar la factura en la base de datos
		return facturaRespository.save(factura);
				
	}
	
}
