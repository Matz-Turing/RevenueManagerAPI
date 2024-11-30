package br.com.etec.rotacerta.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_RECEITA")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECEITA")
    private Long idReceita;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "VL_RECEITA", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    @Column(name = "DT_RECEITA", nullable = false)
    private LocalDateTime data;

    @Column(name = "TX_DESCRICAO", length = 100)
    private String descricao;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricoReceita> historicosReceitas;

    public Receita() {
        this.data = LocalDateTime.now();
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data != null ? data : LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HistoricoReceita> getHistoricosReceitas() {
        return historicosReceitas;
    }

    public void setHistoricosReceitas(List<HistoricoReceita> historicosReceitas) {
        this.historicosReceitas = historicosReceitas;
    }
}