package com.example.examen.Categoria;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue
    private Integer CAT_id;
    @Basic
    private String CAT_nombre;

    private String CAT_descripcion;
  // Constructor que acepta CAT_id
  public Categoria(Integer CAT_id) {
    this.CAT_id = CAT_id;
}
}
