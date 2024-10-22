package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Aluno;
import br.com.pucminas.lds3.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

    @Autowired
    private AlunoRepository alunoRepository;

   
    public Aluno criarAluno(Aluno aluno) {
        logger.info("Tentando criar aluno: {}", aluno);
        try {
            Aluno novoAluno = alunoRepository.save(aluno);
            logger.info("Aluno criado com sucesso: {}", novoAluno);
            return novoAluno;
        } catch (Exception e) {
            logger.error("Erro ao criar aluno: ", e);
            throw e;
        }
    }

   
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }
    
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> buscarAlunoPorEmail(String email) {
        return alunoRepository.findByEmail(email);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id);
        if (alunoExistente.isPresent()) {
            Aluno aluno = alunoExistente.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setCPF(alunoAtualizado.getCPF());
            aluno.setRG(alunoAtualizado.getRG());
            aluno.setEndereco(alunoAtualizado.getEndereco());
            aluno.setCurso(alunoAtualizado.getCurso());
            aluno.setSaldo(alunoAtualizado.getSaldo());
            aluno.setInstituicao(alunoAtualizado.getInstituicao());
            return alunoRepository.save(aluno);
        } else {
            return null; 
        }
    }


    
}



