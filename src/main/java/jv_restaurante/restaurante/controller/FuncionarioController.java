package jv_restaurante.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jv_restaurante.restaurante.dto.FuncionarioDto;
import jv_restaurante.restaurante.service.FuncionarioService;

@RestController
@RequestMapping("/restaurante/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/{idRestaurante}")
	public void postFuncionario(@PathVariable Long idRestaurante, @RequestBody FuncionarioDto funcionarioDto) {
		funcionarioService.postFuncionario(idRestaurante, funcionarioDto);
	}
}