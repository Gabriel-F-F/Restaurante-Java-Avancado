package jv_restaurante.restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.dto.FuncionarioDto;
import jv_restaurante.restaurante.entity.FuncionarioEntity;
import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.repository.FuncionarioRepository;
import jv_restaurante.restaurante.repository.RestauranteRepository;
import jv_restaurante.restaurante.service.FuncionarioService;

@Service
public class FuncionarioServiceImp implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Override
	public FuncionarioDto postFuncionario(Long idRestaurante, FuncionarioDto funcionarioDto) {
		RestauranteEntity restauranteEntity = restauranteRepository.findRestauranteById(idRestaurante);
		FuncionarioEntity funcionarioAdicionado = funcionarioRepository.save(new FuncionarioEntity(funcionarioDto, restauranteEntity));
		return new FuncionarioDto(funcionarioAdicionado);
	}
}