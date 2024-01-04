package com.ecommerce.ecommerce.detalleOrden;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle,Integer> {
    List<Detalle> findByVenta_Id(Integer id);
}