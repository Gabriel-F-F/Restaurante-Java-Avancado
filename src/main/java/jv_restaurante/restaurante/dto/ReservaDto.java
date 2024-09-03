package jv_restaurante.restaurante.dto;

import java.time.LocalDate;

import jv_restaurante.restaurante.entity.ReservaEntity;
import jv_restaurante.restaurante.enuns.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {
	private Long id;
	private Long idCliente;
	private Long idMesa;
	private LocalDate dataReserva;
	private Long quantidadePessoas;
	private StatusEnum status;
	private String observacao;
	
	public ReservaDto(ReservaEntity entity) {
		this.id = entity.getId();
		this.idCliente = entity.getCliente().getId();
		this.idMesa = entity.getMesa().getId();
		this.dataReserva = entity.getDataReserva();
		this.quantidadePessoas = entity.getQuantidadePessoas();
		this.status = entity.getStatus();
		this.observacao = entity.getObservacao();
	}
}