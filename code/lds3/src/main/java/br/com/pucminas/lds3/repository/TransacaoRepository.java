package br.com.pucminas.lds3.repository;

import java.util.Optional;

import br.com.pucminas.lds3.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Optional<Transacao> findById(Long id);
}