package jv_restaurante.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv_restaurante.restaurante.dto.ReservaDto;
import jv_restaurante.restaurante.service.ReservaService;

@RestController
@RequestMapping("/restaurante/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@PostMapping("/adicionar/{idCliente}/{idMesa}")
	public void postReserva(@PathVariable Long idCliente, @PathVariable Long idMesa, @RequestBody ReservaDto reservaDto) {
		reservaService.postReserva(idCliente, idMesa, reservaDto);
	}
	
	@PutMapping("/atualizar-reserva/{idReserva}")
	public void putReserva(@PathVariable Long idReserva, @RequestBody ReservaDto reservaDto) {
		reservaService.putReserva(idReserva, reservaDto);
	}
	
	@PutMapping("/atualizar-status/{idReserva}")
	public void putStatusReserva(@PathVariable Long idReserva, @RequestBody ReservaDto reservaDto) {
		reservaService.putStatusReserva(idReserva, reservaDto);
	}
}