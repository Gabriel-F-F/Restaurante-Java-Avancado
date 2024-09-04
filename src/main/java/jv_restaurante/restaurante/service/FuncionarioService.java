package jv_restaurante.restaurante.service;

import java.util.List;

import jv_restaurante.restaurante.dto.FuncionarioDto;

public interface FuncionarioService {

	List<FuncionarioDto> getFuncionarioPorRestaurante(Long idRestaurante);
	
	FuncionarioDto postFuncionario(Long idRestaurante, FuncionarioDto funcionarioDto);
	
	void putFuncionario(Long idFuncionario, FuncionarioDto funcionarioDto);
}