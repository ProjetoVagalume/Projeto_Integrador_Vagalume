package org.generation.vagalume.repository;

import java.util.Optional;
import org.generation.vagalume.model.UsuarioVagalume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioVagalumeRepository extends JpaRepository<UsuarioVagalume, Long> {
	public Optional<UsuarioVagalume> findByUsuario(String usuario);
}
