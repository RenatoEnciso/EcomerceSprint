package com.ecommerce.ecommerce.usuario;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
@Controller
// @RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor

public class ClienteController {
     private final ClienteService usuarioService;
    
    @PostMapping
    public void createUsuario(@RequestBody Cliente usuario){
           usuarioService.createCategoria(usuario);
    }
        
    @GetMapping
    public  java.util.List<Cliente> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    
     @PatchMapping("/{id}")
    public void updateUsuario(@PathVariable Integer id, @RequestBody Cliente usuario) {
        usuarioService.updateCategoria(id, usuario);
    }
    

     @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
    }


  @RequestMapping("/index")
     public String hola1(Model modelo) {
    
        List<Cliente> $clientes = getAllUsuarios();
       modelo.addAttribute("clientes",$clientes);
        return "cliente";
  }


    @GetMapping("/create")
    public String mostrarFormularioCrear(Model modelo) {
        modelo.addAttribute("nuevoCliente", new Cliente()); 
        return "create";
    }

    @PostMapping("/create")
    public String crearNuevoCliente(@ModelAttribute Cliente nuevoCliente) {
        usuarioService.createCategoria(nuevoCliente);
        return "redirect:/cliente/index"; 
    }


    @GetMapping("/update/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model modelo) {
        Cliente cliente = usuarioService.getClientePorId(id);
        modelo.addAttribute("cliente", cliente);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable Integer id, @ModelAttribute Cliente cliente) {
        usuarioService.updateCategoria(id, cliente);
        return "redirect:/cliente/index";
    }

    @PostMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/cliente/index";
    }
}
