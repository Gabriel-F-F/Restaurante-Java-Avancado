package jv_restaurante.restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import jv_restaurante.restaurante.entity.FuncionarioEntity;
import jv_restaurante.restaurante.enuns.CargoFuncionarioEnum;
import jv_restaurante.restaurante.enuns.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDto {
	private Long id;
	private CargoFuncionarioEnum cargo;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private Long cargaHoraria;
	
	private String nome;
	private String cpf;
	private String sobrenome;
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String telefone;
	
	public FuncionarioDto(FuncionarioEntity entity) {
		this.id = entity.getId();
		this.cargo = entity.getCargo();
		this.dataAdmissao = entity.getDataAdmissao();
		this.salario = entity.getSalario();
		this.cargaHoraria = entity.getCargaHoraria();
		
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.sobrenome = entity.getSobrenome();
		this.dataNascimento = entity.getDataNascimento();
		this.sexo = entity.getSexo();
		this.telefone = entity.getTelefone();
	}
}