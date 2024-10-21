package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.Transacao;
import br.com.pucminas.lds3.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
@CrossOrigin(origins = "http://localhost:3000")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        Transacao novaTransacao = transacaoService.criarTransacao(transacao);
        return ResponseEntity.ok(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        List<Transacao> transacoes = transacaoService.listarTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Long id) {
        return transacaoService.buscarTransacaoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable Long id, @RequestBody Transacao transacao) {
        Transacao transacaoAtualizada = transacaoService.atualizarTransacao(id, transacao);
        if (transacaoAtualizada != null) {
            return ResponseEntity.ok(transacaoAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

   /* @PostMapping("/notificar")
    public ResponseEntity<Void> notificar(@RequestBody Transacao transacao) {
        transacaoService.notificar(transacao);
        return ResponseEntity.ok().build();
    } */
}