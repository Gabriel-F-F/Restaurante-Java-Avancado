package jv_restaurante.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv_restaurante.restaurante.enuns.CargoFuncionarioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "funcionario")
@Getter
public class FuncionarioEntity extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cargo", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private CargoFuncionarioEnum cargo;
	
	@Column(name = "data_admissao", nullable = false)
	private LocalDate dataAdmissao;
	
	@Column(name = "salario", nullable = false)
	private BigDecimal salario;
	
	@Column(name = "carga_horaria", nullable = false)
	private Long cargaHoraria;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
}