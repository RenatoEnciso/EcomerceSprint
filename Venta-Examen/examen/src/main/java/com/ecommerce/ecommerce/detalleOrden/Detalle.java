package com.ecommerce.ecommerce.detalleOrden;

import com.ecommerce.ecommerce.orden.Venta;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DET_id;

    @Basic
    private Integer PRO_id;
    private int DET_cantidad;


    @ManyToOne
    @JoinColumn(name = "id") // Esto especifica la columna en la tabla detalle_orden que se asocia con la relación ManyToOne
    private Venta venta;
}
