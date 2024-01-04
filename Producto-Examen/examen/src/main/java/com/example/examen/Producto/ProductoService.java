package com.example.examen.Producto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductoService {
     private final ProductoRepository productoRepository;
    

     public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public java.util.List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public java.util.Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }

    public void updateProducto(Integer id, Producto updatedProducto) {
        java.util.Optional<Producto> existingProducto = productoRepository.findById(id);
        if (existingProducto.isPresent()) {
            Producto producto = existingProducto.get();
            producto.setPRO_nombre(updatedProducto.getPRO_nombre());
            producto.setPRO_precio(updatedProducto.getPRO_precio());
            producto.setPRO_stock(updatedProducto.getPRO_stock());
            producto.setCategoria(updatedProducto.getCategoria());
            productoRepository.save(producto);
        } else {
            
        }
    }

    public void deleteProducto(Integer id) {
        
        java.util.Optional<Producto> existingProducto = productoRepository.findById(id);
        if (existingProducto.isPresent()) {
            productoRepository.deleteById(id);
        }
    } 
    

}
