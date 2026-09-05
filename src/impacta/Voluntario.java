package impacta;

import java.util.Objects;

public class Voluntario {

    private String nome;
    private String email;
    private String matricula;
    private int pontuacao;
    private int quantidadeAcoes;

    public Voluntario(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.pontuacao = 0;
        this.quantidadeAcoes = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQuantidadeAcoes() {
        return quantidadeAcoes;
    }

    public void setQuantidadeAcoes(int quantidadeAcoes) {
        this.quantidadeAcoes = quantidadeAcoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voluntario that = (Voluntario) o;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                ", pontuacao=" + pontuacao +
                ", quantidadeAcoes=" + quantidadeAcoes + '}';
    }
}
