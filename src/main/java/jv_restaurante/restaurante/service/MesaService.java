package jv_restaurante.restaurante.service;

import java.time.LocalDate;
import java.util.List;
import jv_restaurante.restaurante.dto.MesaDto;

public interface MesaService {

	List<MesaDto> getMesaPorRestaurante(Long idRestaurante);
	
	List<MesaDto> getMesaPorCapacidade(Long idRestaurante, Integer capacidadePessoas, LocalDate data);
	
	MesaDto postMesa(Long idRestaurante, MesaDto mesaDto);
	
	void putMesa(Long idMesa, MesaDto mesaDto);
}