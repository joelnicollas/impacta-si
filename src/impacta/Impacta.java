package impacta;

import java.util.HashMap;
import java.util.Map;

public class Impacta implements VoluntarioInterface {

    private Map<String, Voluntario> voluntarios;
    private Map<Integer, AcaoSocioambiental> acoes;
    private int proximoIdAcao;

    public Impacta() {
        this.voluntarios = new HashMap<>();
        this.acoes = new HashMap<>();
        this.proximoIdAcao = 1;
    }

    public boolean cadastrarVoluntario(String nome, String email, String matricula) {
        return false;
    }
    public String exibirVoluntario(String email) {
        return null;
    }

    @Override
    public String[] listarVoluntario() {
        return new String[0];
    }

    public int cadastrarPlantio(String titulo, String descricao, String data,
                                int maxParticipantes, int qtdMudas) {
        return -1;
    }
    public int cadastrarMutirao(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras) {
        return -1;
    }
    public int cadastrarOficina(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras, boolean kitMaterial) {
        return -1;
    }
    public boolean inscreverVoluntario(String emailVoluntario, int idAcao) {
        return false;
    }
    public String exibirDetalhesAcao(int idAcao) {
        return null;
    }
}