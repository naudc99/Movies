package es.ndc.api_movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ndc.api_movies.entities.RoleEntity;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);
}
