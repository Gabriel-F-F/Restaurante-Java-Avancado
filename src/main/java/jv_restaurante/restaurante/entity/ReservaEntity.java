package jv_restaurante.restaurante.entity;

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
import jv_restaurante.restaurante.enuns.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reserva")
@Getter
public class ReservaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mesa_id", nullable = false)
	private MesaEntity mesa;
	
	@Column(name = "data_reserva", nullable = false)
	private LocalDate dataReserva;
	
	@Column(name = "quantidade_pessoas", nullable = false)
	private Integer quantidadePessoas;
	
	@Column(name = "status", nullable = false)
	private StatusEnum status;
	
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<PedidoEntity> pedidos;
}