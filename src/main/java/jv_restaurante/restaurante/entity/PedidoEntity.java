package jv_restaurante.restaurante.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv_restaurante.restaurante.dto.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedido")
@Getter
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "reserva_id", nullable = false)
	private ReservaEntity reserva;
	
	@Column(name = "nome_prato", nullable = false)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	public PedidoEntity(PedidoDto dto, ReservaEntity reservaEntity) {
		this.id = dto.getId();
		this.reserva = reservaEntity;
		this.descricao = dto.getDescricao();
		this.valor = dto.getValor();
	}
	
	public PedidoEntity putPedido(PedidoDto dto) {
		this.descricao = dto.getDescricao();
		this.valor = dto.getValor();
		return this;
	}
}