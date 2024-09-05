package jv_restaurante.restaurante.repository;

import java.time.LocalDate;
import java.util.List;

import jv_restaurante.restaurante.entity.MesaEntity;

public interface MesaRepositoryCustom {

	List<MesaEntity> getMesasPorCapacidadePessoa(Long idRestaurante, Integer capacidadePessoas, LocalDate data);
}