package com.co.beepers.model.usuario.gateways;

import com.co.beepers.model.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> findUsuarioByNumeroDocumento(Integer numeroDocumento);
    List<Usuario> getAllUsuario();

}
