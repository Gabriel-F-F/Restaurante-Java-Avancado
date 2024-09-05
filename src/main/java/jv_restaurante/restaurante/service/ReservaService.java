package jv_restaurante.restaurante.service;

import jv_restaurante.restaurante.dto.ReservaDto;

public interface ReservaService {

	ReservaDto postReserva(Long idCliente, Long idMesa, ReservaDto reservaDto);

	void putReserva(Long idReserva, ReservaDto reservaDto);
	
	void putStatusReserva(Long idReserva, ReservaDto reservaDto);
}