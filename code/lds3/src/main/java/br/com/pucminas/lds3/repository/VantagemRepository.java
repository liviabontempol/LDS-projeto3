package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Vantagem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VantagemRepository extends JpaRepository<Vantagem, Long> {
    Optional<Vantagem> findById(Long id);
}
