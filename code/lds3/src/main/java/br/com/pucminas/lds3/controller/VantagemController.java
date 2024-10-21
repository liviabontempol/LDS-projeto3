package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.Vantagem;
import br.com.pucminas.lds3.service.VantagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vantagens")
@CrossOrigin(origins = "http://localhost:3000")
public class VantagemController {

    @Autowired
    private VantagemService vantagemService;

    @PostMapping
    public ResponseEntity<Vantagem> criarVantagem(@RequestBody Vantagem vantagem) {
        Vantagem novaVantagem = vantagemService.criarVantagem(vantagem);
        return ResponseEntity.ok(novaVantagem);
    }

    @GetMapping
    public ResponseEntity<List<Vantagem>> listarVantagens() {
        List<Vantagem> vantagens = vantagemService.listarVantagens();
        return ResponseEntity.ok(vantagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vantagem> buscarVantagemPorId(@PathVariable Long id) {
        return vantagemService.buscarVantagemPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vantagem> atualizarVantagem(@PathVariable Long id, @RequestBody Vantagem vantagem) {
        Vantagem vantagemAtualizada = vantagemService.atualizarVantagem(id, vantagem);
        if (vantagemAtualizada != null) {
            return ResponseEntity.ok(vantagemAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVantagem(@PathVariable Long id) {
        vantagemService.deletarVantagem(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrarVantagem")
    public ResponseEntity<Vantagem> cadastrarVantagem(@RequestBody Vantagem vantagem) {
        Vantagem vantagemCadastrada = vantagemService.cadastrarVantagem(vantagem);
        return ResponseEntity.ok(vantagemCadastrada);
    }
}