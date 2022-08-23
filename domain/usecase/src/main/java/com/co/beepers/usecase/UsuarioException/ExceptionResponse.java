package com.co.beepers.usecase.UsuarioException;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private String code;
    private LocalDateTime date;
}


