package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Resgate;
import br.com.pucminas.lds3.model.Aluno;
import br.com.pucminas.lds3.model.Vantagem;
import br.com.pucminas.lds3.repository.AlunoRepository;
import br.com.pucminas.lds3.repository.ResgateRepository;
import br.com.pucminas.lds3.repository.VantagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResgateService {

    @Autowired
    private ResgateRepository resgateRepository;

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private AlunoRepository alunoRepository;


    public Resgate criarResgate(Resgate resgate) {
        return resgateRepository.save(resgate);
    }

    public List<Resgate> listarResgates() {
        return resgateRepository.findAll();
    }

    public Optional<Resgate> buscarResgatePorId(Long id) {
        return resgateRepository.findById(id);
    }

    public Resgate atualizarResgate(Long id, Resgate resgateAtualizado) {
        Optional<Resgate> resgateExistente = resgateRepository.findById(id);
        if (resgateExistente.isPresent()) {
            Resgate resgate = resgateExistente.get();
            resgate.setValor(resgateAtualizado.getValor());
            resgate.setData(resgateAtualizado.getData());
            // Atualizar outros campos conforme necessário
            return resgateRepository.save(resgate);
        }
        return null;
    }

    @Transactional
    public Resgate resgatarVantagem(Vantagem vantagem) {
        Aluno aluno = new Aluno(null, null, null, null, null, null, null, null, null);
        aluno.setNome(null);
        aluno.setEmail(null);
        aluno.setCPF(null);
        aluno.setRG(null);
        aluno.setPassword(null);
        aluno.setEndereco(null);
        aluno.setCurso(null);
        aluno.setInstituicao(null);
        aluno.setSaldo(null);

        aluno = alunoRepository.findById(aluno.getId())
            .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        Vantagem vantage = vantagemRepository.findById(vantagem.getId())
            .orElseThrow(() -> new IllegalArgumentException("Vantagem não encontrada"));

            
        if (aluno.getSaldo() < vantagem.getCusto()) {
            throw new IllegalStateException("Saldo insuficiente para resgatar esta vantagem");
        }

        Resgate resgate = new Resgate(null, vantagem, aluno, 0, null);
        resgate.setAluno(aluno);
        resgate.setVantagem(vantagem);
        resgate.setValor(vantagem.getCusto());
        resgate.setData(new Date());

        
        aluno.setSaldo(aluno.getSaldo() - vantagem.getCusto());
        alunoRepository.save(aluno);


        return resgateRepository.save(resgate);
    }
}