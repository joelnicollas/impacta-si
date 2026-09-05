package impacta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AcaoSocioambiental {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected int id;
    protected String titulo;
    protected String descricao;
    protected LocalDateTime data;
    protected int capacidadeMaxima;

    protected Voluntario[] inscritos;
    protected int quantidadeInscritos;

    public AcaoSocioambiental(int id, String titulo, String descricao, LocalDateTime data, int capacidadeMaxima) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.capacidadeMaxima = capacidadeMaxima;
        this.inscritos = new Voluntario[capacidadeMaxima];
        this.quantidadeInscritos = 0;
    }

    public abstract int calcularPontuacao();

    public boolean inscrever(Voluntario voluntario) {
        if (voluntario == null) {
            throw new IllegalArgumentException("Voluntário não pode ser nulo");
        }

        if (quantidadeInscritos >= capacidadeMaxima) {
            throw new AcaoLotadaException(id);
        }

        for (int i = 0; i < quantidadeInscritos; i++) {
            if (inscritos[i].equals(voluntario)) {
                throw new InscricaoDuplicadaException(voluntario.getEmail(), id);
            }
        }

        inscritos[quantidadeInscritos] = voluntario;
        quantidadeInscritos++;
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
        sb.append("Inscritos (").append(quantidadeInscritos).append("/").append(capacidadeMaxima).append("): ");
        for (int i = 0; i < quantidadeInscritos; i++) {
            sb.append(inscritos[i].getNome());
            if (i < quantidadeInscritos - 1) sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}
