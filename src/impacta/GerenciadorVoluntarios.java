package impacta;

import java.util.Arrays;
import java.util.Comparator;

public class GerenciadorVoluntarios implements VoluntarioInterface {

    private Voluntario[] voluntarios;
    private int totalVoluntarios;

    public GerenciadorVoluntarios() {
        this.voluntarios = new Voluntario[10];
        this.totalVoluntarios = 0;
    }

    @Override
    public boolean cadastrarVoluntario(String nome, String email, String matricula) {
        for (int i = 0; i < totalVoluntarios; i++) {
            if (voluntarios[i].getEmail().equalsIgnoreCase(email)) {
                throw new EmailDuplicadoException(email);
            }
        }

        if (totalVoluntarios == voluntarios.length) {
            voluntarios = Arrays.copyOf(voluntarios, voluntarios.length * 2);
        }

        voluntarios[totalVoluntarios] = new Voluntario(nome, email, matricula);
        totalVoluntarios++;
        return true;
    }

    @Override
    public String exibirVoluntario(String email) {
        for (int i = 0; i < totalVoluntarios; i++) {
            if (voluntarios[i].getEmail().equalsIgnoreCase(email)) {
                return voluntarios[i].toString();
            }
        }
        return null;
    }

    @Override
    public String[] listarVoluntario() {
        Voluntario[] ordenados = Arrays.copyOf(voluntarios, totalVoluntarios);
        Arrays.sort(ordenados,
                Comparator.comparingInt(Voluntario::getPontuacao).reversed()
                        .thenComparing(Voluntario::getNome));

        String[] resultado = new String[totalVoluntarios];
        for (int i = 0; i < totalVoluntarios; i++) {
            resultado[i] = ordenados[i].toString();
        }
        return resultado;
    }

    public Voluntario buscarVoluntario(String email) {
        for (int i = 0; i < totalVoluntarios; i++) {
            if (voluntarios[i].getEmail().equalsIgnoreCase(email)) {
                return voluntarios[i];
            }
        }
        return null;
    }
}