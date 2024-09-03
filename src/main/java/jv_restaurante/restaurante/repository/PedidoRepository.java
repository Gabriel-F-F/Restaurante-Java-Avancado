package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}