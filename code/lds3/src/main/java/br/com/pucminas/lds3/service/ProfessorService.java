package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Professor;
import br.com.pucminas.lds3.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
}
