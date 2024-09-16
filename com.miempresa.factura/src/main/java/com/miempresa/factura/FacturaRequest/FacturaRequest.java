package com.miempresa.factura.FacturaRequest;

import lombok.Data;

@Data
public class FacturaRequest {
	private Long clienteId;
	private Long productoId;
	private int cantidad;
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getProductoId() {
		return productoId;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
