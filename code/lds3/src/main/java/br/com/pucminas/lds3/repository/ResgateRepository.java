package br.com.pucminas.lds3.repository;

import br.com.pucminas.lds3.model.Empresa;
import br.com.pucminas.lds3.model.Resgate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ResgateRepository extends JpaRepository<Resgate, Long> {
    Optional<Resgate> findById(Long id);

     @Query("SELECT r FROM Resgate r WHERE r.vantagem.empresa = :empresa")
    List<Resgate> findByVantagemEmpresa(@Param("empresa") Empresa empresa);

}