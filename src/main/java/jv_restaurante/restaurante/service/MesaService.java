package jv_restaurante.restaurante.service;

import java.util.List;
import jv_restaurante.restaurante.dto.MesaDto;

public interface MesaService {

	List<MesaDto> getMesaPorRestaurante(Long idRestaurante);
	
	MesaDto postMesa(Long idRestaurante, MesaDto mesaDto);
	
	void putMesa(Long idMesa, MesaDto mesaDto);
}