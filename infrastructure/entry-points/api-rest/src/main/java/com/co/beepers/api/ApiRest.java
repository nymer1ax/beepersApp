package com.co.beepers.api;
import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.usecase.CrearUsuarioUseCase;
import com.co.beepers.usecase.GetAllUsuariosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final GetAllUsuariosUseCase getAllUsuariosUseCase;

    @PostMapping
    public ResponseEntity<Usuario> crearusuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(crearUsuarioUseCase.crearUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(getAllUsuariosUseCase.getAllUsuarios());
    }
}
