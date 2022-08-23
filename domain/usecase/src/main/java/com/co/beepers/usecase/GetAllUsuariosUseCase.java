package com.co.beepers.usecase;

import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioNoEncontradoException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GetAllUsuariosUseCase {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuariosByDocument(Optional<Integer> numDocumento){

       var usuarios = usuarioRepository.getAllUsuario();

       if(usuarios.isEmpty()){
           throw new UsuarioNoEncontradoException("No existen usuarios registrados");
       }

        if(numDocumento.isPresent()){

           boolean existeDocumento = usuarios.stream().anyMatch(u -> u.getNumeroDocumento().equals(numDocumento.get()));

            if(!existeDocumento){
                throw new UsuarioNoEncontradoException("No existe usuario numero documento: 23445322");
            }

           return usuarioRepository.getAllByNumeroDocumento(numDocumento.get());
        }

       return usuarios;
    }



}
