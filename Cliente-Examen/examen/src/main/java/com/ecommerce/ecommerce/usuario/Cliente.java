package com.ecommerce.ecommerce.usuario;

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

public class Cliente {
    @Id
    @GeneratedValue
    private Integer CLI_id;
    @Basic
    private String CLI_nombre;
    private String CLI_apellido;
    private String CLI_direccion;
    private Integer CLI_edad;
    private String CLI_celular;
    private String CLI_email;
}
