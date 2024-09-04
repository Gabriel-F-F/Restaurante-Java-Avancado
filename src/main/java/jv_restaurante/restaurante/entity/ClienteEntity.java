package jv_restaurante.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import jv_restaurante.restaurante.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
@Getter
public class ClienteEntity extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "quantidade_reservas", nullable = false)
	private Integer quantidadeReservas;
	
	@Column(name = "quantidade_valor_gasto", nullable = false)
	private BigDecimal quantidadeValorGasto;
	
	@Column(name = "flg_bloqueado")
	private Boolean bloqueado;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ReservaEntity> reservas;

	public ClienteEntity(ClienteDto dto, RestauranteEntity restauranteEntity) {
		this.id = dto.getId();
		this.dataCadastro = dto.getDataCadastro();
		this.quantidadeReservas = dto.getQuantidadeReservas();
		this.quantidadeValorGasto = dto.getQuantidadeValorGasto();
		this.bloqueado = false;
		this.restaurante = restauranteEntity;
		
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.sobrenome = dto.getSobrenome();
		this.dataNascimento = dto.getDataNascimento();
		this.sexo = dto.getSexo();
		this.telefone = dto.getTelefone();
	}
	
	public ClienteEntity putCliente(ClienteDto dto) {
		this.dataCadastro = dto.getDataCadastro();
		this.quantidadeReservas = dto.getQuantidadeReservas();
		this.quantidadeValorGasto = dto.getQuantidadeValorGasto();
		this.bloqueado = false;
		
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.sobrenome = dto.getSobrenome();
		this.dataNascimento = dto.getDataNascimento();
		this.sexo = dto.getSexo();
		this.telefone = dto.getTelefone();
		return this;
	}
}