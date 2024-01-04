package com.example.examen.Categoria;

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
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
 private final CategoriaService categoriaService;
    
 @PostMapping
 public void createCategoria(@RequestBody Categoria categoria) {
 
     categoriaService.createCategoria(categoria);
 }


    @GetMapping 
    
    public  java.util.List<Categoria> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }
    
     @PatchMapping("/{id}")
    public void updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoriaService.updateCategoria(id, categoria);
    }
    

     @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
    }
}
