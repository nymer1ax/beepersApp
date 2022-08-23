package com.co.beepers.usecase;

import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = GetAllUsuariosUseCase.class)
public class GetAllUsuariosUseCaseTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private GetAllUsuariosUseCase getAllUsuariosUseCase;

    @Test
    public void getAllByDocument(){
        List<Usuario> usuarios = usuarioRepository.getAllByNumeroDocumento(23445322);

        when(getAllUsuariosUseCase.getAllUsuariosByDocument(Optional.of(23445322))).thenReturn(usuarios);

        Assertions.assertEquals(usuarioRepository.getAllByNumeroDocumento(23445322), getAllUsuariosUseCase.getAllUsuariosByDocument(Optional.of(23445322)));

    }
}
