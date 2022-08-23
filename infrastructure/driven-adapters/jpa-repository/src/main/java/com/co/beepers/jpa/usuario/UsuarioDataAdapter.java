package com.co.beepers.jpa.usuario;

import com.co.beepers.jpa.helper.AdapterOperations;
import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UsuarioDataAdapter extends AdapterOperations<Usuario, UsuarioData, Long, UsuarioDataRepository> implements UsuarioRepository {

    public UsuarioDataAdapter(UsuarioDataRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Usuario.class/* change for domain model */));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Optional<Usuario> findUsuarioByNumeroDocumento(Integer numeroDocumento) {
        return Optional.empty();
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return null;
    }
}
