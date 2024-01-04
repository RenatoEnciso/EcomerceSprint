package com.ecommerce.ecommerce.detalleOrden;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DetalleService {
    private final DetalleRepository detalleRepository;

    public void createDetalle(Detalle detalle) {
        detalleRepository.save(detalle);
    }

    public void createDetalleList(java.util.List<Detalle> detalleList) {
        detalleRepository.saveAll(detalleList);
    }

    public java.util.List<Detalle> getAllDetalles() {
        return detalleRepository.findAll();
    }

    public java.util.List<Detalle> getDetalleByid(Integer id) {
        return detalleRepository.findByVenta_Id(id);
    }

    public void deleteDetalle(Integer  id) {
       

        if (detalleRepository.existsById(id)) {
         
           detalleRepository.deleteById(id);
        } 
    }

    public void updateDetalle(Integer id, Detalle detalle) {

        if (detalleRepository.existsById(id)) {
         
            detalle.setDET_id(id);
            detalleRepository.save(detalle);
        } 
    }
}
