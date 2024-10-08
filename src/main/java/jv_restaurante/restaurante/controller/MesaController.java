package jv_restaurante.restaurante.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jv_restaurante.restaurante.dto.MesaDto;
import jv_restaurante.restaurante.service.MesaService;

@RestController
@RequestMapping("/restaurante/mesa")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@GetMapping("/buscar/{idRestaurante}")
	public List<MesaDto> getMesaPorRestaurante(@PathVariable Long idRestaurante) {
		return mesaService.getMesaPorRestaurante(idRestaurante);
	}
	
	@GetMapping("/buscar-por-capacidade/{idRestaurante}/{capacidadePessoas}/{data}")
	public List<MesaDto> ge(@PathVariable Long idRestaurante, @PathVariable Integer capacidadePessoas, @PathVariable LocalDate data) {
		return mesaService.getMesaPorCapacidade(idRestaurante, capacidadePessoas, data);
	}
	
	@PostMapping("/adicionar/{idRestaurante}")
	public void postMesa(@PathVariable Long idRestaurante, @RequestBody MesaDto mesaDto) {
		mesaService.postMesa(idRestaurante, mesaDto);
	}
	
	@PutMapping("/atualizar/{idMesa}")
	public void putMesa(@PathVariable Long idMesa, @RequestBody MesaDto mesaDto) {
		mesaService.putMesa(idMesa, mesaDto);
	}
}