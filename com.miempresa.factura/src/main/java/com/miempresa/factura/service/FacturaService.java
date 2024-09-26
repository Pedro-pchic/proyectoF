package com.miempresa.factura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.miempresa.factura.entity.Factura;
import com.miempresa.factura.modelos.Cliente;
import com.miempresa.factura.modelos.Producto;
import com.miempresa.factura.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private RestTemplate restTemplate; // Aquí inyectamos el RestTemplate, no el RestTemplateConfig

    private final String CLIENTE_SERVICE_URL = "http://localhost:8082/api/clientes"; // Corregido el doble slash
    private final String PRODUCTO_SERVICE_URL = "http://localhost:8084/productos";

    public Factura crearFactura(Factura facturaEntity) {
        // Obtener datos del cliente
        Cliente cliente = restTemplate.getForObject(CLIENTE_SERVICE_URL + "/" + facturaEntity.getIdCliente(), Cliente.class);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado con id: " + facturaEntity.getIdCliente());
        }

        // Obtener datos del producto
        Producto producto = restTemplate.getForObject(PRODUCTO_SERVICE_URL + "/" + facturaEntity.getIdProducto(), Producto.class);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado con id: " + facturaEntity.getIdProducto());
        }

        // Verificar stock disponible
        if (producto.getStock() < facturaEntity.getCantidad()) {
            throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
        }

        // Crear la factura con los datos obtenidos
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdCliente(cliente.getId());
        nuevaFactura.setIdProducto(producto.getId());
        nuevaFactura.setCantidad(facturaEntity.getCantidad());
        nuevaFactura.setFecha(facturaEntity.getFecha());

        // Calcular total (cantidad * precio del producto)
        nuevaFactura.setTotal(facturaEntity.getCantidad() * producto.getPrecio());

        // Guardar la factura en la base de datos
        return facturaRepository.save(nuevaFactura);
    }

    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada con id: " + id));
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
