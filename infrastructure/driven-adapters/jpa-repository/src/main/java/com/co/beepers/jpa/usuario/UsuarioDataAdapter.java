package com.co.beepers.jpa.usuario;

import com.co.beepers.jpa.helper.AdapterOperations;
import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

        var user = mapperUsuarioAUsuarioData(usuario);

        this.repository.save(user);

        return mapperUsuarioDataAUsuario(user);
    }

    @Override
    public Optional<Usuario> findUsuarioByNumeroDocumento(Integer numeroDocumento) {
        return this.repository.findUsuarioDataByNumeroDocumento(numeroDocumento).map(this::mapperUsuarioDataAUsuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
         var usuarios = this.repository.findAll();
         return usuarios.stream().map(this::mapperUsuarioDataAUsuario).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> getAllByNumeroDocumento(Integer numDocumento) {
        return this.repository.findAllByNumeroDocumento(numDocumento).stream().map(this::mapperUsuarioDataAUsuario).collect(Collectors.toList());
    }


    private Usuario mapperUsuarioDataAUsuario(UsuarioData usuarioData){
        return Usuario.builder()
                .id(usuarioData.getId())
                .primerNombre(usuarioData.getPrimerNombre())
                .segundoNombre(usuarioData.getSegundoNombre())
                .primerApellido(usuarioData.getPrimerApellido())
                .segundoApellido(usuarioData.getSegundoApellido())
                .telefono(usuarioData.getTelefono())
                .direccion(usuarioData.getDireccion())
                .ciudad(usuarioData.getCiudad())
                .tipoDocumento(usuarioData.getTipoDocumento())
                .numeroDocumento(usuarioData.getNumeroDocumento())
                .build();
    }

    private UsuarioData mapperUsuarioAUsuarioData(Usuario usuario){
        return UsuarioData.builder()
                .id(usuario.getId())
                .primerNombre(usuario.getPrimerNombre())
                .segundoNombre(usuario.getSegundoNombre())
                .primerApellido(usuario.getPrimerApellido())
                .segundoApellido(usuario.getSegundoApellido())
                .telefono(usuario.getTelefono())
                .direccion(usuario.getDireccion())
                .ciudad(usuario.getCiudad())
                .tipoDocumento(usuario.getTipoDocumento())
                .numeroDocumento(usuario.getNumeroDocumento())
                .build();
    }
}
