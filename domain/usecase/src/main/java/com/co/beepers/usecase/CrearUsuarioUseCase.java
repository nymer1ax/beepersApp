package com.co.beepers.usecase;

import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import com.co.beepers.usecase.UsuarioException.Exceptions.CustomException;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioExisteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){

        boolean usuarioExisteParaCrear = usuarioRepository.findUsuarioByNumeroDocumento(usuario.getNumeroDocumento()).isPresent();

        if (usuarioExisteParaCrear){
            throw new UsuarioExisteException("Este usuario existe");
        }

        boolean numeroDocumentoYaExiste = usuarioRepository.getAllUsuario().stream().anyMatch(u -> u.getNumeroDocumento().equals(usuario.getNumeroDocumento()));

        if(numeroDocumentoYaExiste){
            throw new CustomException("Numero documento ya existe");
        }

        Usuario usuarioAcrear = Usuario.builder()
                .id(usuario.getId())
                .primerNombre("CRISTIANO")
                .segundoNombre("RONALDO")
                .primerApellido("DO SANTOS")
                .segundoApellido("AVEIRO")
                .telefono("300CR7")
                .direccion("SIR MATT BUSBY WAY, OLD TRAFFORD, STRETFORD")
                .ciudad("MANCHESTER")
                .tipoDocumento(usuario.getTipoDocumento())
                .numeroDocumento(usuario.getNumeroDocumento())
                .build();

            return usuarioRepository.crearUsuario(usuarioAcrear);

    }
}
