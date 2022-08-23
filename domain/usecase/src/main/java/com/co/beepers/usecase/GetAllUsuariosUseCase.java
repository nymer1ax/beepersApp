package com.co.beepers.usecase;

import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioNoEncontradoException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllUsuariosUseCase {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios(){

       var usuarios = usuarioRepository.getAllUsuario();

       if(usuarios.size() == 0){
           throw new UsuarioNoEncontradoException("No existen usuarios registrados");
       }

       return usuarios;
    }

}
