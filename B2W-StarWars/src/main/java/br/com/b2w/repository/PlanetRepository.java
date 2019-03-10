package br.com.b2w.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.b2w.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
	
	@Query("select p from Planet p where p.nome = :nome")
    public List<Planet> findByNomeIs(@Param("nome") String nome);
	
	@Query("select p from Planet p where p.id = :id")
    public List<Planet> findById(@Param("id") Long id);
    
}
