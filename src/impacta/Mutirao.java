package impacta;

import java.time.LocalDateTime;

public class Mutirao extends AcaoSocioambiental {

    private int duracaoHoras;

    public Mutirao(int id, String titulo, String descricao, LocalDateTime data,
                   int maxParticipantes, int duracaoHoras) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.duracaoHoras = duracaoHoras;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    @Override
    public int calcularPontuacao() {
        return 4 * duracaoHoras;
    }

    @Override
    protected String detalhesEspecificos() {
        return "Tipo: Mutirão de Reciclagem\nDuração: " + duracaoHoras + " horas\n";
    }
}
