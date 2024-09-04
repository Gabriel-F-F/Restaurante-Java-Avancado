package jv_restaurante.restaurante.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jv_restaurante.restaurante.dto.ClienteDto;
import jv_restaurante.restaurante.service.ClienteService;

@RestController
@RequestMapping("/restaurante/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/buscar/{idRestaurante}")
	public List<ClienteDto> getClientePorRestaurante(@PathVariable Long idRestaurante) {
		return clienteService.getClientePorRestaurante(idRestaurante);
	}
	
	@PostMapping("/adicionar/{idRestaurante}")
	public void postCliente(@PathVariable Long idRestaurante, @RequestBody ClienteDto clienteDto) {
		clienteService.postCliente(idRestaurante, clienteDto);
	}
	
	@PutMapping("/atualizar/{idCliente}")
	public void putFuncionario(@PathVariable Long idCliente, @RequestBody ClienteDto clienteDto) {
		clienteService.putCliente(idCliente, clienteDto);
	}
}