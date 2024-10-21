package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Empresa;
import br.com.pucminas.lds3.model.Vantagem;
import br.com.pucminas.lds3.repository.EmpresaRepository;
import br.com.pucminas.lds3.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Vantagem criarVantagem(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public List<Vantagem> listarVantagens() {
        return vantagemRepository.findAll();
    }

    public Optional<Vantagem> buscarVantagemPorId(Long id) {
        return vantagemRepository.findById(id);
    }

    public Vantagem atualizarVantagem(Long id, Vantagem vantagemAtualizada) {
        Optional<Vantagem> vantagemExistente = vantagemRepository.findById(id);
        if (vantagemExistente.isPresent()) {
            Vantagem vantagem = vantagemExistente.get();
            vantagem.setDescricao(vantagemAtualizada.getDescricao());
            vantagem.setCusto(vantagemAtualizada.getCusto());
            // Atualizar outros campos conforme necessário
            return vantagemRepository.save(vantagem);
        }
        return null;
    }

    public void deletarVantagem(Long id) {
        vantagemRepository.deleteById(id);
    }

    public Vantagem cadastrarVantagem(Vantagem vantagem) {
        // Verifica se a empresa parceira associada à vantagem existe
        Empresa empresa = empresaRepository.findById(vantagem.getEmpresa().getId())
            .orElseThrow(() -> new IllegalArgumentException("Empresa parceira não encontrada"));

        // Verifica se o custo da vantagem é válido
        if (vantagem.getCusto() <= 0) {
            throw new IllegalArgumentException("O custo da vantagem deve ser maior que zero");
        }

        // Associa a empresa à vantagem
        vantagem.setEmpresa(empresa);

        // Salva a nova vantagem
        return vantagemRepository.save(vantagem);
    }
}