package jv_restaurante.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/{idRestaurante}")
	public void postMesa(@PathVariable Long idRestaurante, @RequestBody MesaDto mesaDto) {
		mesaService.postMesa(idRestaurante, mesaDto);
	}
}