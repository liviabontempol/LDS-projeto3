package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.Transacao;
import br.com.pucminas.lds3.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> buscarTransacaoPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada) {
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if (transacaoExistente.isPresent()) {
            Transacao transacao = transacaoExistente.get();
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setMensagem(transacaoAtualizada.getMensagem());
            // Atualizar outros campos conforme necessário
            return transacaoRepository.save(transacao);
        }
        return null;
    }

    public void deletarTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}