package impacta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class AcaoSocioambiental {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected int id;
    protected String titulo;
    protected String descricao;
    protected LocalDateTime data;
    protected int capacidadeMaxima;
    protected List<Voluntario> inscritos;

    public AcaoSocioambiental(int id, String titulo, String descricao, LocalDateTime data, int capacidadeMaxima) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.capacidadeMaxima = capacidadeMaxima;
        this.inscritos = new ArrayList<>();
    }

    public abstract int calcularPontuacao();

    public boolean inscrever(Voluntario voluntario) {
        if (voluntario == null || inscritos.size() >= capacidadeMaxima || inscritos.contains(voluntario)) {
            return false;
        }
        inscritos.add(voluntario);
        return true;
    }

    protected abstract String detalhesEspecificos();

    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Data: ").append(data.format(FORMATTER)).append("\n");
        sb.append(detalhesEspecificos());
        sb.append("Pontuação: ").append(calcularPontuacao()).append("\n");
        sb.append("Inscritos (").append(inscritos.size()).append("/").append(capacidadeMaxima).append("): ");
        for (int i = 0; i < inscritos.size(); i++) {
            sb.append(inscritos.get(i).getNome());
            if (i < inscritos.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}