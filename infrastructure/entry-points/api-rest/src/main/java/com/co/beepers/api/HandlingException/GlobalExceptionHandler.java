package com.co.beepers.api.HandlingException;

import com.co.beepers.usecase.UsuarioException.ExceptionResponse;
import com.co.beepers.usecase.UsuarioException.Exceptions.CustomException;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioExisteException;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<ExceptionResponse> usuarioNoEncontrado(UsuarioNoEncontradoException ex){

        ExceptionResponse response = ExceptionResponse.builder()
                .code("NOT_FOUND")
                .message(ex.getMessage())
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioExisteException.class)
    public ResponseEntity<ExceptionResponse> usuarioExiste(UsuarioExisteException ex){

        ExceptionResponse response = ExceptionResponse.builder()
                .code("CONFLICT")
                .message(ex.getMessage())
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex){

        ExceptionResponse response = ExceptionResponse.builder()
                .code("BAD_REQUEST")
                .message(ex.getMessage())
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }





}
