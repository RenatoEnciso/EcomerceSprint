package com.example.examen.Producto;

import com.example.examen.Categoria.Categoria;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Producto {
   @Id
    @GeneratedValue
    private Integer PRO_id;
    @Basic
    private String PRO_nombre;
    private float PRO_precio;
    private Integer  PRO_stock;

     @ManyToOne
    @JoinColumn(name = "CAT_id")
    private Categoria categoria;;

}
