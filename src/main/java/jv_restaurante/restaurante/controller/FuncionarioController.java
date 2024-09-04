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
import jv_restaurante.restaurante.dto.FuncionarioDto;
import jv_restaurante.restaurante.service.FuncionarioService;

@RestController
@RequestMapping("/restaurante/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/buscar/{idRestaurante}")
	public List<FuncionarioDto> getMesaPorRestaurante(@PathVariable Long idRestaurante) {
		return funcionarioService.getFuncionarioPorRestaurante(idRestaurante);
	}
	
	@PostMapping("/adicionar/{idRestaurante}")
	public void postFuncionario(@PathVariable Long idRestaurante, @RequestBody FuncionarioDto funcionarioDto) {
		funcionarioService.postFuncionario(idRestaurante, funcionarioDto);
	}
	
	@PutMapping("/atualizar/{idFuncionario}")
	public void putFuncionario(@PathVariable Long idFuncionario, @RequestBody FuncionarioDto funcionarioDto) {
		funcionarioService.putFuncionario(idFuncionario, funcionarioDto);
	}
}