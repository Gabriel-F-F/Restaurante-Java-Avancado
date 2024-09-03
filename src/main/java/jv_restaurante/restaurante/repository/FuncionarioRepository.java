package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

}