package jv_restaurante.restaurante.dto;

import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.enuns.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestauranteDto {
	private Long id;
	private String nome;
	private String cpnj;
	private Long estrelas;
	private TipoComidaEnum tipoComida;
	
	public RestauranteDto(RestauranteEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpnj = entity.getCpnj();
		this.estrelas = entity.getEstrelas();
		this.tipoComida = entity.getTipoComida();
	}
}