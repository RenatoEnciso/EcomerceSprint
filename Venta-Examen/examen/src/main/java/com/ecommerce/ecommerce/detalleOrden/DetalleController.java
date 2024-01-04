package com.ecommerce.ecommerce.detalleOrden;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalle")
@RequiredArgsConstructor

public class DetalleController {
    private final DetalleService DetalleService;

    @PostMapping
    public ResponseEntity<String> createDetalle(@RequestBody java.util.List<Detalle> detalleList) {
        try {
            DetalleService.createDetalleList(detalleList);
            return ResponseEntity.ok("Detalles de la orden creados correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear detalles de la orden: " + e.getMessage());
        }
    }

    @GetMapping
    public java.util.List<Detalle> getOrdenes(){
        return DetalleService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public java.util.List<Detalle> getDetalleByid(@PathVariable Integer id) {
        return DetalleService.getDetalleByid(id);
    }

     @PatchMapping("/{id}")
    public void updateDetalle(@PathVariable Integer id, @RequestBody Detalle detalle) {
        DetalleService.updateDetalle(id, detalle);;
    }

    @DeleteMapping("/{id}")
    public void deleteDetalle(@PathVariable Integer id) {
        DetalleService.deleteDetalle(id);
    } 


}
