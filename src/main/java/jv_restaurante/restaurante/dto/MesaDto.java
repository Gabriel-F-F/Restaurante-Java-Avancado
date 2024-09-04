package jv_restaurante.restaurante.dto;

import jv_restaurante.restaurante.entity.MesaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaDto {
	private Long id;
	private Integer numero;
	private Integer capacidadePessoas;
	private Long idRestaurante;
	
	public MesaDto(MesaEntity entity) {
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.capacidadePessoas = entity.getCapacidadePessoas();
		this.idRestaurante = entity.getRestaurante().getId();
	}
}