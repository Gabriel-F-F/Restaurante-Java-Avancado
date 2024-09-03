package jv_restaurante.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv_restaurante.restaurante.dto.RestauranteDto;
import jv_restaurante.restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;
	
	@PostMapping
	public void postRestaurante(@RequestBody RestauranteDto restauranteDto) {
		restauranteService.postRestaurante(restauranteDto);
	}
}