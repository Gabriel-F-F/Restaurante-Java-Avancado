package jv_restaurante.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv_restaurante.restaurante.dto.PedidoDto;
import jv_restaurante.restaurante.service.PedidoService;

@RestController
@RequestMapping("/restaurante/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/adicionar/{idReserva}")
	public void postPedido(@PathVariable Long idReserva, @RequestBody PedidoDto pedidoDto) {
		pedidoService.postPedido(idReserva, pedidoDto);
	}
}