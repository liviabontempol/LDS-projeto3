package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public @Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
