package br.com.etec.rotacerta.controller;

import br.com.etec.rotacerta.entity.Receita;
import br.com.etec.rotacerta.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<Receita> listarTodasReceitas() {
        return receitaService.listarTodasReceitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> listarReceitaPorId(@PathVariable Long id) {
        Optional<Receita> receita = receitaService.buscarReceitaPorId(id);
        return receita.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Receita> salvarReceita(@RequestBody Receita receita) {
        Receita receitaSalva = receitaService.salvarReceita(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizarReceita(@PathVariable Long id, @RequestBody Receita receita) {
        Optional<Receita> receitaExistente = receitaService.buscarReceitaPorId(id);
        if (receitaExistente.isPresent()) {
            receita.setIdReceita(id);
            Receita receitaAtualizada = receitaService.salvarReceita(receita);
            return ResponseEntity.ok(receitaAtualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable Long id) {
        Optional<Receita> receitaExistente = receitaService.buscarReceitaPorId(id);
        if (receitaExistente.isPresent()) {
            receitaService.deletarReceita(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}