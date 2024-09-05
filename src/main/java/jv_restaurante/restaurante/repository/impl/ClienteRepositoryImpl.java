package jv_restaurante.restaurante.repository.impl;

//import java.util.Objects;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
//import com.querydsl.core.types.Projections;
//import com.querydsl.jpa.impl.JPAQuery;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jv_restaurante.restaurante.dto.ClienteDto;
//import jv_restaurante.restaurante.entity.QClienteEntity;
//import jv_restaurante.restaurante.entity.QRestauranteEntity;
import jv_restaurante.restaurante.repository.ClienteRepositoryCustom;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

//	final QClienteEntity cliente = QClienteEntity.clienteEntity;
//	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
//
//	@Override
//	public Page<ClienteDto> getClientes(Pageable pageable, String searchTerm) {
//		BooleanBuilder condicoes = new BooleanBuilder();
//		
//		if(Objects.nonNull(searchTerm) && !searchTerm.isEmpty()) {
//			condicoes.and(cliente.nome.containsIgnoreCase(searchTerm));
//		}
//		
//		JPAQuery<ClienteDto> query = new JPAQuery<>();
//		query.select(Projections.constructor(ClienteDto.class, cliente))
//				.from(restaurante)
//				.join(restaurante.clientes, cliente)
//				.where(condicoes)
//				.orderBy(cliente.dataCadastro.asc(), cliente.nome.asc(), cliente.id.asc());
//		
//		query.limit(pageable.getPageSize());
//		query.offset(pageable.getOffset());
//		
//		return new PageImpl<ClienteDto>(query.fetch(), pageable, query.fetchCount());
//	}
}