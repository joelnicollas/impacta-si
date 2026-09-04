package impacta;

import java.time.LocalDateTime;

public class plantio extends AcaoSocioambiental {

    private int qtdMudas;

    public plantio(int id, String titulo, String descricao, LocalDateTime data,
                   int maxParticipantes, int qtdMudas) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.qtdMudas = qtdMudas;
    }

    public int getQtdMudas() {
        return qtdMudas;
    }

    @Override
    public int calcularPontuacao() {
        return 5 + (2 * qtdMudas);
    }

    @Override
    protected String detalhesEspecificos() {
        return "Tipo: Plantio de Mudas\nQuantidade de mudas: " + qtdMudas + "\n";
    }
}