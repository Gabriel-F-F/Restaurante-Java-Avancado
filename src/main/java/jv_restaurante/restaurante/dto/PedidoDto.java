package jv_restaurante.restaurante.dto;

import java.math.BigDecimal;

import jv_restaurante.restaurante.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDto {
	private Long id;
	private Long idReserva;
	private String descricao;
	private BigDecimal valor;
	
	public PedidoDto(PedidoEntity entity) {
		this.id = entity.getId();
		this.idReserva = entity.getReserva().getId();
		this.descricao = entity.getDescricao();
		this.valor = entity.getValor();
	}
}