package com.ecommerce.ecommerce.orden;

import java.sql.Timestamp;

//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Venta {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private Integer CLI_id;
    private Timestamp VEN_fecha;

}
