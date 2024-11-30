package br.com.etec.rotacerta.enums;

public enum TempoDepositoEnum {
    DIARIO("Diário"),
    SEMANAL("Semanal"),
    QUINZENAL("Quinzenal"),
    MENSAL("Mensal"),
    BIMESTRAL("Bimestral"),
    TRIMESTRAL("Trimestral"),
    SEMESTRAL("Semestral"),
    ANUAL("Anual");

    private final String descricao;

    TempoDepositoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TempoDepositoEnum fromString(String valor) {
        for (TempoDepositoEnum tempo : TempoDepositoEnum.values()) {
            if (tempo.name().equalsIgnoreCase(valor)) {
                return tempo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TempoDepositoEnum: " + valor);
    }
}