package jv_restaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv_restaurante.restaurante.entity.RestauranteEntity;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {

	RestauranteEntity findRestauranteById(Long id);
}