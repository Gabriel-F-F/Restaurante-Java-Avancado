package jv_restaurante.restaurante.service;

import jv_restaurante.restaurante.dto.FuncionarioDto;

public interface FuncionarioService {

	FuncionarioDto postFuncionario(Long idRestaurante, FuncionarioDto funcionarioDto);
}