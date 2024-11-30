package br.com.etec.rotacerta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TBL_HISTORICO_RECEITAS")
public class HistoricoReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO_RECEITAS")
    private Long idHistoricoReceitas;

    @ManyToOne
    @JoinColumn(name = "ID_RECEITA", nullable = false)
    private Receita receita;  // Relacionamento com a entidade Receita

    @Column(name = "VL_RECEITA", precision = 8, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "DT_RECEITA", nullable = false)
    private LocalDateTime data;

    @Column(name = "TX_DESCRICAO", length = 200)
    private String descricao;
}