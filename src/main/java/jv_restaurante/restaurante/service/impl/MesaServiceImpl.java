package jv_restaurante.restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.dto.MesaDto;
import jv_restaurante.restaurante.entity.MesaEntity;
import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.repository.MesaRepository;
import jv_restaurante.restaurante.repository.RestauranteRepository;
import jv_restaurante.restaurante.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public MesaDto postMesa(Long idRestaurante, MesaDto mesaDto) {
		RestauranteEntity restauranteEntity = restauranteRepository.findRestauranteById(idRestaurante);
		MesaEntity mesaAdicionada = mesaRepository.save(new MesaEntity(mesaDto, restauranteEntity));
		return new MesaDto(mesaAdicionada);
	}
}