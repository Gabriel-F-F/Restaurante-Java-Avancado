package jv_restaurante.restaurante.entity;

import java.time.LocalDate;
import jakarta.persistence.MappedSuperclass;
import jv_restaurante.restaurante.enuns.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String sobrenome;
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String telefone;
}