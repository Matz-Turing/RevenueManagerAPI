package br.com.etec.rotacerta.repository;

import br.com.etec.rotacerta.entity.HistoricoReceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoReceitaRepository extends JpaRepository<HistoricoReceita, Long> {

    Optional<HistoricoReceita> findById(Long id);

    List<HistoricoReceita> findAll();

    List<HistoricoReceita> findByReceita_IdReceita(Long receitaId);

    void deleteById(Long id);
}