package br.com.etec.rotacerta.service;

import br.com.etec.rotacerta.entity.HistoricoReceita;
import br.com.etec.rotacerta.entity.Receita;
import br.com.etec.rotacerta.repository.HistoricoReceitaRepository;
import br.com.etec.rotacerta.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private HistoricoReceitaRepository historicoReceitaRepository;

    public Receita salvarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodasReceitas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarReceitaPorId(Long id) {
        return receitaRepository.findById(id);
    }

    public void deletarReceita(Long id) {
        receitaRepository.deleteById(id);
    }

    public HistoricoReceita adicionarHistoricoReceita(Long receitaId, HistoricoReceita historicoReceita) {
        Optional<Receita> receita = receitaRepository.findById(receitaId);

        if (receita.isPresent()) {
            historicoReceita.setReceita(receita.get());
            return historicoReceitaRepository.save(historicoReceita);
        } else {
            throw new IllegalArgumentException("Receita não encontrada com ID: " + receitaId);
        }
    }

    public List<HistoricoReceita> listarHistoricosPorReceita(Long receitaId) {
        return historicoReceitaRepository.findByReceita_IdReceita(receitaId);
    }
}