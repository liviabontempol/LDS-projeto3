package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Aluno;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findById(Long id);
    Optional<Aluno> findByEmail(String email);
}
