package jv_restaurante.restaurante.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.dto.FuncionarioDto;
import jv_restaurante.restaurante.entity.FuncionarioEntity;
import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.enuns.CargoFuncionarioEnum;
import jv_restaurante.restaurante.repository.FuncionarioRepository;
import jv_restaurante.restaurante.repository.RestauranteRepository;
import jv_restaurante.restaurante.service.FuncionarioService;

@Service
public class FuncionarioServiceImp implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public void validaCargaHoraria(Integer cargaHoraria) {
		if(cargaHoraria > 220) {
			throw new IllegalArgumentException("A carga horária não deve ultrapassar 220 horas!");
		}
	}
	
	public void validaSalario(CargoFuncionarioEnum cargo, BigDecimal salario) {
		Integer comparacao = salario.compareTo(BigDecimal.valueOf(1412));
		if(cargo != CargoFuncionarioEnum.FREELANCER && comparacao <= 0) {
			throw new IllegalArgumentException("O cargo do funcionário deve receber um valor superior a um salário mínimo!");
		}
	}
	
	@Override
	public List<FuncionarioDto> getFuncionarioPorRestaurante(Long idRestaurante) {
		List<FuncionarioEntity> listaFuncionarios = funcionarioRepository.findAll();
		List<FuncionarioEntity> funcionariosEncontrados = listaFuncionarios
														.stream()
														.filter(funcionario -> funcionario.getRestaurante().getId().equals(idRestaurante))
														.toList();
		return funcionariosEncontrados.stream().map(FuncionarioDto::new).toList();
	}
	
	@Override
	public FuncionarioDto postFuncionario(Long idRestaurante, FuncionarioDto funcionarioDto) {
		validaCargaHoraria(funcionarioDto.getCargaHoraria());
		validaSalario(funcionarioDto.getCargo(), funcionarioDto.getSalario());
		
		RestauranteEntity restauranteEntity = restauranteRepository.findRestauranteById(idRestaurante);
		FuncionarioEntity funcionarioAdicionado = funcionarioRepository.save(new FuncionarioEntity(funcionarioDto, restauranteEntity));
		return new FuncionarioDto(funcionarioAdicionado);
	}
	
	@Override
	public void putFuncionario(Long idFuncionario, FuncionarioDto funcionarioDto) {
		Optional<FuncionarioEntity> funcionarioEncontrado = funcionarioRepository.findById(idFuncionario);
		if(funcionarioEncontrado.isPresent()) {
			FuncionarioEntity funcionarioEntity = funcionarioEncontrado.get();
			funcionarioEntity.putFuncionario(funcionarioDto);
			funcionarioRepository.save(funcionarioEntity);
		}
	}
}