package com.co.beepers.usecase;

import com.co.beepers.model.usuario.Usuario;
import com.co.beepers.model.usuario.gateways.UsuarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CrearUsuarioUseCase.class)
public class CrearUsuarioUseCaseTest {

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private CrearUsuarioUseCase crearUsuarioUseCase;

    @Test
    public void crearUsuarioTest(){
        Usuario usuarioAcrear = Usuario.builder()
                .id(1L)
                .primerNombre("CRISTIANO")
                .segundoNombre("RONALDO")
                .primerApellido("DO SANTOS")
                .segundoApellido("AVEIRO")
                .telefono("300CR7")
                .direccion("SIR MATT BUSBY WAY, OLD TRAFFORD, STRETFORD")
                .ciudad("MANCHESTER")
                .tipoDocumento("C")
                .numeroDocumento(23445322)
                .build();

        when(usuarioRepository.crearUsuario(any(Usuario.class))).thenReturn(usuarioAcrear);
        crearUsuarioUseCase.crearUsuario(usuarioAcrear);
        
        Assertions.assertEquals(23445322, usuarioAcrear.getNumeroDocumento());


    }


}
