package org.generation.vagalume.repository;



import java.util.List;

import org.generation.vagalume.model.PostagemVagalume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemVagalumeRepository extends JpaRepository<PostagemVagalume, Long>{
	public List<PostagemVagalume> findAllByNomeContainingIgnoreCase
	(@Param("nome") String nome);

}
