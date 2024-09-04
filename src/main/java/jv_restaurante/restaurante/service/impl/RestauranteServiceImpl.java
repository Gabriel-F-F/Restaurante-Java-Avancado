package jv_restaurante.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

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
	public List<RestauranteDto> getRestaurante() {
		List<RestauranteEntity> listaRestaurantes = restauranteRepository.findAll();
		return listaRestaurantes.stream().map(RestauranteDto::new).toList();
	}
	
	@Override
	public RestauranteDto postRestaurante(RestauranteDto restauranteDto) {
		RestauranteEntity restauranteAdicionado = restauranteRepository.save(new RestauranteEntity(restauranteDto));
		return new RestauranteDto(restauranteAdicionado);
	}
	
	@Override
	public void putRestaurante(Long idRestaurante, RestauranteDto restauranteDto) {
		Optional<RestauranteEntity> restauranteEncontrado = restauranteRepository.findById(idRestaurante);
		if(restauranteEncontrado.isPresent()) {
			RestauranteEntity restauranteEntity = restauranteEncontrado.get();
			restauranteEntity.putRestaurante(restauranteDto);
			restauranteRepository.save(restauranteEntity);
		}
	}

}