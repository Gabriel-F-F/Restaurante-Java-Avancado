package jv_restaurante.restaurante.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jv_restaurante.restaurante.dto.MesaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "mesa")
@Getter
public class MesaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	@Column(name = "capacidade_pessoas", nullable = false)
	private Integer capacidadePessoas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
	
	@OneToMany(mappedBy = "mesa", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ReservaEntity> reservas;
	
	public MesaEntity(MesaDto dto, RestauranteEntity restauranteEntity) {
		this.id = dto.getId();
		this.numero = dto.getNumero();
		this.capacidadePessoas = dto.getCapacidadePessoas();
		this.restaurante = restauranteEntity;
	}
	
	public MesaEntity putMesa(MesaDto dto) {
		this.numero = dto.getNumero();
		this.capacidadePessoas = dto.getCapacidadePessoas();
		return this;
	}
}