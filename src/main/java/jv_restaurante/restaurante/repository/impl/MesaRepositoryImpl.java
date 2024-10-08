package jv_restaurante.restaurante.repository.impl;

import java.time.LocalDate;
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

	@Override
	public List<MesaEntity> getMesasPorCapacidadePessoa(Long idRestaurante, Integer capacidadePessoas, LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@PersistenceContext
//	private EntityManager em;
//	
//	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
//	final QReservaEntity reserva = QReservaEntity.reservaEntity;
//	final QMesaEntity mesa = QMesaEntity.mesaEntity;
//	
//	public List<MesaEntity> getMesasPorCapacidadePessoa(Long restauranteId, Integer capacidadePessoas, LocalDate data) {
//		var query = new JPAQuery<MesaEntity>(em);
//		
//		query.select(mesa)
//			.distinct()
//			.from(restaurante)
//			.innerJoin(restaurante.mesas, mesa)
//			.innerJoin(mesa.reservas, reserva)
//			.where(restaurante.id.eq(restauranteId)
//			.and(mesa.capacidadePessoas.eq(capacidadePessoas) //terminou aq
//			.and(reserva.dataReserva.eq(data))
//			.and(reserva.status.eq())));
//		
//		return query.fetch();
//	}
}