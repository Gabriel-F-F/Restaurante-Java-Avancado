package jv_restaurante.restaurante.service;

import java.util.List;

import jv_restaurante.restaurante.dto.RestauranteDto;

public interface RestauranteService {
	
	List<RestauranteDto> getRestaurante();
	
	RestauranteDto postRestaurante(RestauranteDto restauranteDto);
	
	void putRestaurante(Long idRestaurante, RestauranteDto restauranteDto);
}