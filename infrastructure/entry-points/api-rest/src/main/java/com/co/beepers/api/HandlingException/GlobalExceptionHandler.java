package com.co.beepers.api.HandlingException;

import com.co.beepers.usecase.UsuarioException.ExceptionResponse;
import com.co.beepers.usecase.UsuarioException.Exceptions.CustomException;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioExisteException;
import com.co.beepers.usecase.UsuarioException.Exceptions.UsuarioNoEncontradoException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ExceptionResponse response = ExceptionResponse.builder()
                .code("UNPROCESSABLE_ENTITY")
                .message(errors.stream().reduce(" ", String::concat))
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));

        ExceptionResponse response = ExceptionResponse.builder()
                .code("UNPROCESSABLE_ENTITY")
                .message(errors.stream().reduce(" ", String::concat))
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }






}
