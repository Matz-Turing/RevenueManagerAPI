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
public class HistoricoReceitaService {

    @Autowired
    private HistoricoReceitaRepository historicoReceitaRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<HistoricoReceita> listarTodosHistoricos() {
        return historicoReceitaRepository.findAll();
    }

    public Optional<HistoricoReceita> buscarHistoricoPorId(Long id) {
        return historicoReceitaRepository.findById(id);
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

    public void deletarHistoricoReceita(Long id) {
        historicoReceitaRepository.deleteById(id);
    }
}