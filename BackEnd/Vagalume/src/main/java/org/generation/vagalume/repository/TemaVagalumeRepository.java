package org.generation.vagalume.repository;

import java.util.List;

import org.generation.vagalume.model.TemaVagalume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TemaVagalumeRepository extends JpaRepository<TemaVagalume, Long>{
	public List<TemaVagalume> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

	}


