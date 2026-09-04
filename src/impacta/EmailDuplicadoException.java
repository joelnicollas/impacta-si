package impacta;

public class EmailDuplicadoException extends RuntimeException {

    public EmailDuplicadoException(String email) {
        super("E-mail já cadastrado: " + email);
    }
}