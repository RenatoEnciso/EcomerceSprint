package com.ecommerce.ecommerce.orden;

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
@RequestMapping("/venta")
@RequiredArgsConstructor

public class VentaController {

    private final VentaService ventaService;

    @PostMapping
    public ResponseEntity<String> createVenta(@RequestBody Venta venta) {
        try {
            ventaService.createVenta(venta);
            String mensaje = "Orden creada exitosamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String mensajeError = "Error al crear la orden.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @GetMapping
    public  java.util.List<Venta> getVentas(){
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVenta(@PathVariable Integer id) {
       java.util. Optional<Venta> producto = ventaService.getVentaById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/{id}")
    public void updateOrden(@PathVariable Integer id, @RequestBody Venta venta) {
        ventaService.updateVenta(id, venta);
    }
    

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Integer id) {
        ventaService.deleteVenta(id);
    }
}
