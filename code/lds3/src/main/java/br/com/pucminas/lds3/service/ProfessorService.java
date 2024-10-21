package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Aluno;
import br.com.pucminas.lds3.model.Professor;
import br.com.pucminas.lds3.model.Transacao;
import br.com.pucminas.lds3.repository.AlunoRepository;
import br.com.pucminas.lds3.repository.ProfessorRepository;
import br.com.pucminas.lds3.repository.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;


    public Professor criarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessorPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor atualizarProfessor(Long id, Professor professorAtualizado) {
        Optional<Professor> professorExistente = professorRepository.findById(id);
        if (professorExistente.isPresent()) {
            Professor professor = professorExistente.get();
            professor.setDepartamento(professorAtualizado.getDepartamento());
            // Atualizar outros campos conforme necessário
            return professorRepository.save(professor);
        }
        return null;
    }

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Transactional
    public void enviarMoeda(Long professorId, Long alunoId, short moeda) {
        Professor professor = professorRepository.findById(professorId)
            .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));

        Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        
        if (professor.getSaldo() < moeda) {
            throw new IllegalStateException("Saldo insuficiente para enviar moedas");
        }

        
        professor.setSaldo((double) (professor.getSaldo() - moeda));
        aluno.setSaldo((double) (aluno.getSaldo() + moeda));

        
        Transacao transacao = new Transacao(alunoId, moeda, null, aluno, professor, null);
        transacao.setProfessor(professor);
        transacao.setAluno(aluno);
        transacao.setValor(moeda);
        transacao.setData(new Date());

        
        professorRepository.save(professor);
        alunoRepository.save(aluno);
        transacaoRepository.save(transacao);
    }
}