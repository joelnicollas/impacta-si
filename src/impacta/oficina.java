package impacta;

import java.time.LocalDateTime;

public class oficina extends AcaoSocioambiental {

    private int duracaoHoras;
    private boolean kitMaterial;

    public oficina(int id, String titulo, String descricao, LocalDateTime data,
                   int maxParticipantes, int duracaoHoras, boolean kitMaterial) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.duracaoHoras = duracaoHoras;
        this.kitMaterial = kitMaterial;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public boolean isKitMaterial() {
        return kitMaterial;
    }

    @Override
    public int calcularPontuacao() {
        int base = 3 * duracaoHoras;
        return kitMaterial ? base + 10 : base;
    }

    @Override
    protected String detalhesEspecificos() {
        return "Tipo: Oficina Ecológica\nDuração: " + duracaoHoras + " horas\n"
                + "Kit de material educativo: " + (kitMaterial ? "Sim" : "Não") + "\n";
    }
}