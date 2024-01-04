package com.example.examen.Categoria;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CategoriaService {
    private final CategoriaRepository categoriaRepon;

    public void createCategoria(Categoria categoria){
           categoriaRepon.save(categoria);
    
    }

    public java.util.List<Categoria> getAllCategorias() {
         return categoriaRepon.findAll();
    } 

    

    public void updateCategoria(Integer categoria_id, Categoria categoria) {

        if (categoriaRepon.existsById(categoria_id)) {
         
            categoria.setCAT_id(categoria_id);
            categoriaRepon.save(categoria);
        } else {
        
            throw new CategoriaNotFoundException("Categoría no encontrada con ID: " +  categoria_id);
        }
    }

    public void deleteCategoria(Integer  categoria_id) {
       

        if (categoriaRepon.existsById( categoria_id)) {
         
          categoriaRepon.deleteById( categoria_id);
        } else {
        
            throw new CategoriaNotFoundException("Categoría no encontrada con ID: " +  categoria_id);
        }
    }

    public class CategoriaNotFoundException extends RuntimeException {

        public CategoriaNotFoundException(String message) {
            super(message);
        }
    }
}
