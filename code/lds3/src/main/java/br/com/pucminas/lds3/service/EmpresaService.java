package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Empresa;
import br.com.pucminas.lds3.model.Resgate;
import br.com.pucminas.lds3.repository.EmpresaRepository;
import br.com.pucminas.lds3.repository.ResgateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ResgateRepository resgateRepository;

    public Empresa criarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> buscarEmpresaPorEmail(String email) {
        return empresaRepository.findByEmail(email);
    }

    public Empresa atualizarEmpresa(Long id, Empresa empresaAtualizada) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()) {
            Empresa empresa = empresaExistente.get();
            empresa.setDescricao(empresaAtualizada.getDescricao());
            // Atualizar outros campos conforme necessário
            return empresaRepository.save(empresa);
        }
        return null;
    }

    public List<String> consultarTrocas(Long id) {
        Empresa empresa = empresaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Empresa  não encontrada"));

        List<Resgate> resgates = resgateRepository.findByVantagemEmpresa(empresa);

        return resgates.stream()
            .map(resgate -> String.format("Aluno: %s, Vantagem: %s, Data: %s",
                resgate.getAluno().getNome(),
                resgate.getVantagem().getDescricao(),
                resgate.getData()))
            .collect(Collectors.toList());
    }
}