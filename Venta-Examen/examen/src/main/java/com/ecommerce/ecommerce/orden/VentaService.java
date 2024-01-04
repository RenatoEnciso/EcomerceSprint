package com.ecommerce.ecommerce.orden;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class VentaService {
    private final VentaRepository ventaRepository;


    public void createVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    public java.util.List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }


    public void updateVenta(Integer id, Venta venta) {

        if (ventaRepository.existsById(id)) {
         
            venta.setId(id);
            ventaRepository.save(venta);
        } else {
        
            throw new OrdenNotFoundException("Orden no encontrada con ID: " +  id);
        }
    }

     
    public java.util.Optional<Venta> getVentaById(Integer id) {
        return ventaRepository.findById(id);
    }

    public void deleteVenta(Integer  id) {
       

        if (ventaRepository.existsById(id)) {
         
          ventaRepository.deleteById(id);
        } else {
        
            throw new OrdenNotFoundException("Orden no encontrada con ID: " +  id);
        }
    }

    public class OrdenNotFoundException extends RuntimeException {

        public OrdenNotFoundException(String message) {
            super(message);
        }
    }
}
