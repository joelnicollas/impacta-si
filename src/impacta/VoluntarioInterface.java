package impacta;

public interface VoluntarioInterface {
    boolean cadastrarVoluntario(String nome, String email, String matricula);
    String exibirVoluntario(String email);
    String[] listarVoluntario();
}
