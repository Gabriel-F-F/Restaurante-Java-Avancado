package jv_restaurante.restaurante.service;

import jv_restaurante.restaurante.dto.PedidoDto;

public interface PedidoService {

	PedidoDto postPedido(Long idReserva, PedidoDto pedidoDto);
}