package impacta;
public class Voluntario {

    private String nome;
    private String email;
    private String matricula;
    private double pontuacao;
    private int quantidadeAcoes;

    public Voluntario(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.pontuacao = pontuacao;
        this.quantidadeAcoes = quantidadeAcoes;
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

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQuantidadeAcoes() {
        return quantidadeAcoes;
    }

    public void setQuantidadeAcoes(int quantidadeAcoes) {
        this.quantidadeAcoes = quantidadeAcoes;
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