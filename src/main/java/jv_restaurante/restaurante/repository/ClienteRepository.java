package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	ClienteEntity findClienteById(Long idCliente);
}