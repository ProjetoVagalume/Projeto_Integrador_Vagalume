package org.generation.vagalume.Repository;


/*import java.time.LocalDateTime;*/
import java.util.List;

import org.generation.vagalume.model.PostagemVagalume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemVagalumeRepository extends JpaRepository<PostagemVagalume, Long>{
	public List<PostagemVagalume> findAllByPostagemtextoContainingIgnoreCase
	(@Param("postagemtexto")String postagemtexto);
	
	/*public List<PostagemVagalume> findAllByDatapostagem
	(@Param("datapostagem") String datapostagem);*/

}
