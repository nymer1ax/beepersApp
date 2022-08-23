package com.co.beepers.jpa.usuario;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudad;
    @Column(name = "tipoDocumento", nullable = false)
    @Pattern(regexp = "(C|P)")
    private String tipoDocumento;
    @Column(name = "numeroDocumento", nullable = false)
    private Integer numeroDocumento;
}
