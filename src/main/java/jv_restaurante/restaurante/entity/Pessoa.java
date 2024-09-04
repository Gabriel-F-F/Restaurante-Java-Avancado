package jv_restaurante.restaurante.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jv_restaurante.restaurante.enuns.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class Pessoa {
	@Column(name = "nome", nullable = false)
	protected String nome;
	
	@Column(name = "cpf", nullable = false, unique = false)
	protected String cpf;
	
	@Column(name = "sobrenome", nullable = false)
	protected String sobrenome;
	
	@Column(name = "data_nascimento", nullable = false)
	protected LocalDate dataNascimento;
	
	@Column(name = "sexo", nullable = false)
	protected SexoEnum sexo;
	
	@Column(name = "telefone", nullable = false)
	protected String telefone;
}