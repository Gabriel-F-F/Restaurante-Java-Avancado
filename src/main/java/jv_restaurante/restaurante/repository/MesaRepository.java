package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.MesaEntity;

public interface MesaRepository extends JpaRepository<MesaEntity, Long>, MesaRepositoryCustom {

	MesaEntity findMesaById(Long idMesa);
	
}