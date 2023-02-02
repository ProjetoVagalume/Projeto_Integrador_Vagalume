package org.generation.vagalume.repository;

import java.util.List;

import org.generation.vagalume.model.TemaVagalume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaVagalumeRepository extends JpaRepository<TemaVagalume, Long>{
	public List<TemaVagalume> findAllByTipodescricaoContainingIgnoreCase (String tipodescricao);
	public List<TemaVagalume> findAllByDescricaoContainingIgnoreCase (String descricao);
	
}

	


