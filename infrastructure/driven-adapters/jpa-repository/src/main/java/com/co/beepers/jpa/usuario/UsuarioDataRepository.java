package com.co.beepers.jpa.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UsuarioDataRepository extends CrudRepository<UsuarioData, Long>, QueryByExampleExecutor<UsuarioData> {
}
