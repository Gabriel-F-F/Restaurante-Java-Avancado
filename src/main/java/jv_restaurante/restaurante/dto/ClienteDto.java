package jv_restaurante.restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jv_restaurante.restaurante.entity.ClienteEntity;
import jv_restaurante.restaurante.enuns.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {
	private Long id;
	private LocalDate dataCadastro;
	private Integer quantidadeReservas;
	private BigDecimal quantidadeValorGasto;
	private Boolean bloqueado;
	private Long idRestaurante;
	
	private String nome;
	private String cpf;
	private String sobrenome;
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String telefone;
	
	public ClienteDto(ClienteEntity entity) {
		this.id = entity.getId();
		this.dataCadastro = entity.getDataCadastro();
		this.quantidadeReservas = entity.getQuantidadeReservas();
		this.quantidadeValorGasto = entity.getQuantidadeValorGasto();
		this.bloqueado = entity.getBloqueado();
		this.idRestaurante = entity.getRestaurante().getId();
		
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.sobrenome = entity.getSobrenome();
		this.dataNascimento = entity.getDataNascimento();
		this.sexo = entity.getSexo();
		this.telefone = entity.getTelefone();
	}
}