package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.Resgate;
import br.com.pucminas.lds3.model.Vantagem;
import br.com.pucminas.lds3.service.ResgateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/resgates")
@CrossOrigin(origins = "http://localhost:3000")
public class ResgateController {

    @Autowired
    private ResgateService resgateService;

    @PostMapping
    public ResponseEntity<Resgate> criarResgate(@RequestBody Resgate resgate) {
        Resgate novoResgate = resgateService.criarResgate(resgate);
        return ResponseEntity.ok(novoResgate);
    }

    @GetMapping
    public ResponseEntity<List<Resgate>> listarResgates() {
        List<Resgate> resgates = resgateService.listarResgates();
        return ResponseEntity.ok(resgates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resgate> buscarResgatePorId(@PathVariable Long id) {
        return resgateService.buscarResgatePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resgate> atualizarResgate(@PathVariable Long id, @RequestBody Resgate resgate) {
        Resgate resgateAtualizado = resgateService.atualizarResgate(id, resgate);
        if (resgateAtualizado != null) {
            return ResponseEntity.ok(resgateAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    /* @PostMapping("/notificar")
    public ResponseEntity<Void> notificar(@RequestBody Resgate resgate) {
        resgateService.notificar(resgate);
        return ResponseEntity.ok().build();
    }*/

    @PostMapping("/resgatarVantagem")
    public ResponseEntity<Void> resgatarVantagem(@RequestBody Vantagem vantagem) {
        resgateService.resgatarVantagem(vantagem);
        return ResponseEntity.ok().build();
    }
}