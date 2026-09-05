package impacta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Impacta implements VoluntarioInterface {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private GerenciadorVoluntarios gerenciadorVoluntarios;
    private AcaoSocioambiental[] acoes;
    private int totalAcoes;
    private int proximoIdAcao;

    public Impacta() {
        this.gerenciadorVoluntarios = new GerenciadorVoluntarios();
        this.acoes = new AcaoSocioambiental[10];
        this.totalAcoes = 0;
        this.proximoIdAcao = 1;
    }

    @Override
    public boolean cadastrarVoluntario(String nome, String email, String matricula) {
        return gerenciadorVoluntarios.cadastrarVoluntario(nome, email, matricula);
    }

    @Override
    public String exibirVoluntario(String email) {
        return gerenciadorVoluntarios.exibirVoluntario(email);
    }

    @Override
    public String[] listarVoluntario() {
        return gerenciadorVoluntarios.listarVoluntario();
    }

    public int cadastrarPlantio(String titulo, String descricao, String data,
                                int maxParticipantes, int qtdMudas) {
        LocalDateTime dataConvertida = LocalDateTime.parse(data, FORMATTER);
        int id = proximoIdAcao++;
        adicionarAcao(new Plantio(id, titulo, descricao, dataConvertida, maxParticipantes, qtdMudas));
        return id;
    }

    public int cadastrarMutirao(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras) {
        LocalDateTime dataConvertida = LocalDateTime.parse(data, FORMATTER);
        int id = proximoIdAcao++;
        adicionarAcao(new Mutirao(id, titulo, descricao, dataConvertida, maxParticipantes, duracaoHoras));
        return id;
    }

    public int cadastrarOficina(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras, boolean kitMaterial) {
        LocalDateTime dataConvertida = LocalDateTime.parse(data, FORMATTER);
        int id = proximoIdAcao++;
        adicionarAcao(new Oficina(id, titulo, descricao, dataConvertida, maxParticipantes, duracaoHoras, kitMaterial));
        return id;
    }

    private void adicionarAcao(AcaoSocioambiental acao) {
        if (totalAcoes == acoes.length) {
            acoes = Arrays.copyOf(acoes, acoes.length * 2);
        }
        acoes[totalAcoes] = acao;
        totalAcoes++;
    }

    private AcaoSocioambiental buscarAcao(int idAcao) {
        for (int i = 0; i < totalAcoes; i++) {
            if (acoes[i].id == idAcao) {
                return acoes[i];
            }
        }
        return null;
    }

    public boolean inscreverVoluntario(String emailVoluntario, int idAcao) {
        Voluntario voluntario = gerenciadorVoluntarios.buscarVoluntario(emailVoluntario);
        if (voluntario == null) {
            throw new IllegalArgumentException("Voluntário não encontrado: " + emailVoluntario);
        }

        AcaoSocioambiental acao = buscarAcao(idAcao);
        if (acao == null) {
            throw new IllegalArgumentException("Ação não encontrada, id: " + idAcao);
        }

        boolean inscrito = acao.inscrever(voluntario);

        if (inscrito) {
            voluntario.setPontuacao(voluntario.getPontuacao() + acao.calcularPontuacao());
            voluntario.setQuantidadeAcoes(voluntario.getQuantidadeAcoes() + 1);
        }

        return inscrito;
    }

    public String exibirDetalhesAcao(int idAcao) {
        AcaoSocioambiental acao = buscarAcao(idAcao);
        if (acao == null) {
            return null;
        }
        return acao.exibirDetalhes();
    }
}


