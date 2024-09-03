package jv_restaurante.restaurante.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv_restaurante.restaurante.enuns.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "restaurante")
@Getter
public class RestauranteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpnj;
	
	@Column(nullable = false)
	private Long estrelas;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoComidaEnum tipoComida;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	List<FuncionarioEntity> funcionarios;
	List<ClienteEntity> clientes;
	List<MesaEntity> mesas;

}