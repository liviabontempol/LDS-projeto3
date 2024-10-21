package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Empresa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        Optional<Empresa> findById(String id);
    Optional<Empresa> findByEmail(String email);
}

