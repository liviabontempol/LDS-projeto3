package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.Professor;
import br.com.pucminas.lds3.model.Aluno;
import br.com.pucminas.lds3.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.criarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = professorService.listarProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarProfessorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.atualizarProfessor(id, professor);
        if (professorAtualizado != null) {
            return ResponseEntity.ok(professorAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{professorId}/enviarMoeda")
    public ResponseEntity<Void> enviarMoeda(@PathVariable Long professorId, @RequestBody Aluno aluno, @RequestParam short moeda) {
        professorService.enviarMoeda(professorId, aluno.getId(), moeda);
        return ResponseEntity.ok().build();
    }

   /*  @GetMapping("/{professorId}/consultarSaldo")
    public ResponseEntity<Short> consultarSaldo(@PathVariable Long professorId) {
        short saldo = professorService.consultarSaldo(professorId);
        return ResponseEntity.ok(saldo);
    }*/
}