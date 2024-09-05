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
import jv_restaurante.restaurante.dto.RestauranteDto;
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
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cnpj", nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "estrelas", nullable = false)
	private Long estrelas;
	
	@Column(name = "tipo_comida", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoComidaEnum tipoComida;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<FuncionarioEntity> funcionarios;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ClienteEntity> clientes;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<MesaEntity> mesas;

	public RestauranteEntity(RestauranteDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cnpj = dto.getCnpj().replaceAll("[\\.\\-/]", "");
		this.estrelas = dto.getEstrelas();
		this.tipoComida = dto.getTipoComida();
	}
	
	public RestauranteEntity putRestaurante(RestauranteDto dto) {
		this.nome = dto.getNome();
		this.cnpj = dto.getCnpj();
		this.estrelas = dto.getEstrelas();
		this.tipoComida = dto.getTipoComida();
		return this;
	}
}