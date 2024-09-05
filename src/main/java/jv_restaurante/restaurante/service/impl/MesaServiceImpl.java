package jv_restaurante.restaurante.service.impl;

import java.util.List;
import java.util.Optional;
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
	public List<MesaDto> getMesaPorRestaurante(Long idRestaurante) {
		List<MesaEntity> listaMesa = mesaRepository.findAll();
		List<MesaEntity> mesasEncontradas = listaMesa.stream().filter(mesa -> mesa.getRestaurante().getId().equals(idRestaurante)).toList();
		return mesasEncontradas.stream().map(MesaDto::new).toList();
	}
	
	@Override
	public MesaDto postMesa(Long idRestaurante, MesaDto mesaDto) {
		RestauranteEntity restauranteEntity = restauranteRepository.findRestauranteById(idRestaurante);
		MesaEntity mesaAdicionada = mesaRepository.save(new MesaEntity(mesaDto, restauranteEntity));
		return new MesaDto(mesaAdicionada);
	}
	
	@Override
	public void putMesa(Long idMesa, MesaDto mesaDto) {
		Optional<MesaEntity> mesaEncontrada = mesaRepository.findById(idMesa);
		if(mesaEncontrada.isPresent()) {
			MesaEntity mesaEntity = mesaEncontrada.get();
			mesaEntity.putMesa(mesaDto);
			mesaRepository.save(mesaEntity);
		}
	}
}