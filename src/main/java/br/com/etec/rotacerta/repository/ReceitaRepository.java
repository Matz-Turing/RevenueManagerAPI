package br.com.etec.rotacerta.repository;

import br.com.etec.rotacerta.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {


    List<Receita> findByIdUsuario(Long idUsuario);


    Optional<Receita> findByIdReceita(Long idReceita);


    List<Receita> findByDescricaoContainingIgnoreCase(String descricao);
}