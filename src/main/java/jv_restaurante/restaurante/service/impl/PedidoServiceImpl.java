package jv_restaurante.restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.dto.PedidoDto;
import jv_restaurante.restaurante.entity.PedidoEntity;
import jv_restaurante.restaurante.entity.ReservaEntity;
import jv_restaurante.restaurante.repository.PedidoRepository;
import jv_restaurante.restaurante.repository.ReservaRepository;
import jv_restaurante.restaurante.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public PedidoDto postPedido(Long idReserva, PedidoDto pedidoDto) {
		ReservaEntity reservaEncontrada = reservaRepository.findReservaById(idReserva);
		PedidoEntity pedidoAdicionado = pedidoRepository.save(new PedidoEntity(pedidoDto, reservaEncontrada));
		return new PedidoDto(pedidoAdicionado);
		
	}
}