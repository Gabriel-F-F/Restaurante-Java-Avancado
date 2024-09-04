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

import jv_restaurante.restaurante.dto.RestauranteDto;
import jv_restaurante.restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;
	
	@GetMapping
	public List<RestauranteDto> getRestaurante(RestauranteDto restauranteDto) {
		return restauranteService.getRestaurante(restauranteDto);
	}
	
	@PostMapping
	public void postRestaurante(@RequestBody RestauranteDto restauranteDto) {
		restauranteService.postRestaurante(restauranteDto);
	}
	
	@PutMapping("/{idRestaurante}")
	public void putRestaurante(@PathVariable Long idRestaurante, @RequestBody RestauranteDto restauranteDto) {
		restauranteService.putRestaurante(idRestaurante, restauranteDto);
	}
}