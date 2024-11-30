package br.com.etec.rotacerta.controller;

import br.com.etec.rotacerta.entity.HistoricoReceita;
import br.com.etec.rotacerta.service.HistoricoReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historicos-receitas")
public class HistoricoReceitaController {

    @Autowired
    private HistoricoReceitaService historicoReceitaService;

    @GetMapping
    public ResponseEntity<List<HistoricoReceita>> listarTodosHistoricos() {
        List<HistoricoReceita> historicos = historicoReceitaService.listarTodosHistoricos();
        return ResponseEntity.ok(historicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoReceita> buscarHistoricoPorId(@PathVariable Long id) {
        Optional<HistoricoReceita> historico = historicoReceitaService.buscarHistoricoPorId(id);

        if (historico.isPresent()) {
            return ResponseEntity.ok(historico.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/{receitaId}")
    public ResponseEntity<HistoricoReceita> adicionarHistoricoReceita(
            @PathVariable Long receitaId,
            @RequestBody HistoricoReceita historicoReceita) {

        try {
            HistoricoReceita novoHistorico = historicoReceitaService.adicionarHistoricoReceita(receitaId, historicoReceita);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoHistorico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirHistoricoReceita(@PathVariable Long id) {
        try {
            historicoReceitaService.deletarHistoricoReceita(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}