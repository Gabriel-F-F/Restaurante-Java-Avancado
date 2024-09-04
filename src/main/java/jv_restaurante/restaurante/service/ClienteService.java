package jv_restaurante.restaurante.service;

import java.util.List;

import jv_restaurante.restaurante.dto.ClienteDto;

public interface ClienteService {

	List<ClienteDto> getClientePorRestaurante(Long idRestaurante);
	
	ClienteDto postCliente(Long idRestaurante, ClienteDto dto);
	
	void putCliente(Long idCliente, ClienteDto clienteDto);
}