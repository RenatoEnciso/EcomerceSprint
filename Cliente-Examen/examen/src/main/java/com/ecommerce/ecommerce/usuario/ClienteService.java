package com.ecommerce.ecommerce.usuario;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository usuarioRepon;

    public void createCategoria(Cliente usuario){
        usuarioRepon.save(usuario);
 
    }

 public java.util.List<Cliente> getAllUsuarios() {
      return usuarioRepon.findAll();
 } 

 public java.util.Optional<Cliente> getClienteById(Integer id) {
    return usuarioRepon.findById(id);
}

 public void updateCategoria(Integer id, Cliente usuario) {

     if (usuarioRepon.existsById(id)) {
      
         usuario.setCLI_id(id);
         usuarioRepon.save(usuario);
     } else {
     
         throw new UsuarioNotFoundException("Usuario no encontrado con ID: " +  id);
     }
 }

 public Cliente getClientePorId(Integer id) {
    java.util.Optional<Cliente> optionalCliente = usuarioRepon.findById(id);

    if (optionalCliente.isPresent()) {
        return optionalCliente.get();
    } else {
        throw new UsuarioNotFoundException("Cliente no encontrado con ID: " + id);
    }
}
 public void deleteUsuario(Integer  id) {
    

     if (usuarioRepon.existsById( id)) {
      
          usuarioRepon.deleteById( id);
     } else {
     
         throw new UsuarioNotFoundException("Usuario no encontrado con ID: " +  id);
     }
 }

 public class UsuarioNotFoundException extends RuntimeException {

     public UsuarioNotFoundException(String message) {
         super(message);
     }
 }
}
