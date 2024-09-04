package jv_restaurante.restaurante.service;

import jv_restaurante.restaurante.dto.MesaDto;

public interface MesaService {

	MesaDto postMesa(Long idRestaurante, MesaDto mesasDto);
}