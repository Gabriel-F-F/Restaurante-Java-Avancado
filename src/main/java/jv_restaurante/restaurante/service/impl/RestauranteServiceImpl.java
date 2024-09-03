package jv_restaurante.restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jv_restaurante.restaurante.dto.RestauranteDto;
import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.repository.RestauranteRepository;
import jv_restaurante.restaurante.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Override
	public RestauranteDto postRestaurante(RestauranteDto restauranteDto) {
		RestauranteEntity restauranteAdicionado = restauranteRepository.save(new RestauranteEntity(restauranteDto));
		return new RestauranteDto(restauranteAdicionado);
	}

}