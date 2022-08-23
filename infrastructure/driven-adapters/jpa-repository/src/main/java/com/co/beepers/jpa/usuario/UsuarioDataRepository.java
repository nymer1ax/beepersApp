package com.co.beepers.jpa.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.util.List;
import java.util.Optional;

public interface UsuarioDataRepository extends JpaRepository<UsuarioData, Long>, QueryByExampleExecutor<UsuarioData> {

    @Query("SELECT u FROM UsuarioData u WHERE u.numeroDocumento= ?1")
    Optional<UsuarioData> findUsuarioDataByNumeroDocumento(Integer numeroDocumento);
    @Query("SELECT u FROM UsuarioData  u where u.numeroDocumento=?1")
    List<UsuarioData> findAllByNumeroDocumento(Integer numeroDocumento);

}
