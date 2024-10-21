package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Professor;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
        Optional<Professor> findById(String id);
    Optional<Professor> findByEmail(String email);
}
