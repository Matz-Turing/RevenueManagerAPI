package br.com.etec.rotacerta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TBL_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA")
    private Long idReserva;

    @Column(name = "VL_RESERVA", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorReserva;

    @Column(name = "TX_DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "TX_TEMPO_DEPOSITO", nullable = false, length = 15)
    private String tempoDeposito;
}
