package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

	ReservaEntity findReservaById(Long idReserva);
}