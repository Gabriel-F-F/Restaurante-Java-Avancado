package jv_restaurante.restaurante.repository.impl;

import java.util.List;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv_restaurante.restaurante.entity.MesaEntity;
import jv_restaurante.restaurante.entity.QMesaEntity;
import jv_restaurante.restaurante.entity.QReservaEntity;
import jv_restaurante.restaurante.entity.QRestauranteEntity;
import jv_restaurante.restaurante.repository.MesaRepositoryCustom;

public class MesaRepositoryImpl implements MesaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QMesaEntity mesa = QMesaEntity.mesaEntity;
	
	public List<MesaEntity> getMesasPorCapacidadePessoa(Long restauranteId, Integer capacidadePessoas) {
		var query = new JPAQuery<MesaEntity>(em);
		
		query.select(mesa).distinct()
			.from(restaurante).join(restaurante.mesas, mesa)
			.where(restaurante.id.eq(restauranteId)
			.and(mesa.capacidadePessoas.eq(capacidadePessoas)));
		
		return query.fetch();
	}
}