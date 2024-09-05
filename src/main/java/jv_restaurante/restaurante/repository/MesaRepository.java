package jv_restaurante.restaurante.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import jv_restaurante.restaurante.entity.MesaEntity;

public interface MesaRepository extends JpaRepository<MesaEntity, Long> {

	MesaEntity findMesaById(Long idMesa);
	
	List<MesaEntity> findMesaPorPessoas(Integer quantidadePessoas);
}