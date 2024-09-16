package com.miempresa.factura.Service;


import com.miempresa.factura.FeignClient.ClienteClient;
import com.miempresa.factura.FeignClient.ProductoClient;
import com.miempresa.factura.entity.Factura;
import com.miempresa.factura.exception.ClienteNotFoundException;
import com.miempresa.factura.exception.FacturaNotFoundException;
import com.miempresa.factura.exception.ProductoNotFoundException;
import com.miempresa.factura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private ClienteClient clienteclient;
    
    @Autowired
    private ProductoClient productoclient;
    
    // Método para crear una factura
    public Factura crearFactura(Long clienteId, Long productoId, int cantidad) 
            throws ClienteNotFoundException, ProductoNotFoundException {
        // Aquí realizarías las validaciones para cliente y producto
    	//validar cliente
        if (clienteclient.obtenerClientePorId(clienteId) ==null) {
            throw new ClienteNotFoundException("Cliente no encontrado");
        }
        //validar producto
        if (productoclient.obtenerProductoPorId(productoId) == null) {
            throw new ProductoNotFoundException("Producto no encontrado");
        }
        //crear factura

        Factura factura = new Factura(clienteId, productoId, cantidad);
        return facturaRepository.save(factura);
    }

    // Obtener todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    // Obtener una factura por ID
    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id);
    }

    // Eliminar una factura por ID
    public void eliminarFactura(Long id) throws Exception {
        Optional<Factura> factura = facturaRepository.findById(id);
        if (!factura.isPresent()) {
            throw new Exception("Factura no encontrada");
        }
        facturaRepository.deleteById(id);
    }
}

