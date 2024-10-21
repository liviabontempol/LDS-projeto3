package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.Empresa;
import br.com.pucminas.lds3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaService.criarEmpresa(empresa);
        return ResponseEntity.ok(novaEmpresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable Long id) {
        return empresaService.buscarEmpresaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa empresaAtualizada = empresaService.atualizarEmpresa(id, empresa);
        if (empresaAtualizada != null) {
            return ResponseEntity.ok(empresaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/consultarTrocas")
    public ResponseEntity<List<String>> consultarTrocas(@PathVariable Long id) {
        List<String> trocas = empresaService.consultarTrocas(id);
        return ResponseEntity.ok(trocas);
    }
}