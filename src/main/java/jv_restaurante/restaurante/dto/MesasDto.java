package jv_restaurante.restaurante.dto;

import jv_restaurante.restaurante.entity.MesaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesasDto {
	private Long id;
	private Long numero;
	private Long capacidadePessoas;
	
	public MesasDto(MesaEntity entity) {
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.capacidadePessoas = entity.getCapacidadePessoas();
	}
}