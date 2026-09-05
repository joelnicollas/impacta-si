package impacta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoluntarioTest {

    @Test
    void deveOrdenarPorPontuacaoDecrescente() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Carlos", "carlos@email.com", "111");
        sistema.cadastrarVoluntario("Ana", "ana@email.com", "222");

        int idAcaoGrande = sistema.cadastrarPlantio("Mutirão Verde", "desc",
                "10/09/2026 09:00", 10, 10);
        int idAcaoPequena = sistema.cadastrarPlantio("Plantio pequeno", "desc",
                "11/09/2026 09:00", 10, 1);

        sistema.inscreverVoluntario("carlos@email.com", idAcaoPequena);
        sistema.inscreverVoluntario("ana@email.com", idAcaoGrande);

        String[] ranking = sistema.listarVoluntario();

        assertEquals(2, ranking.length);
        assertTrue(ranking[0].contains("nome='Ana'"), "Ana deveria vir primeiro (mais pontos)");
        assertTrue(ranking[1].contains("nome='Carlos'"), "Carlos deveria vir em segundo");
    }

    @Test
    void deveDesempatarPorNomeAlfabetico() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Bruno", "bruno@email.com", "111");
        sistema.cadastrarVoluntario("Aline", "aline@email.com", "222");

        int idAcao = sistema.cadastrarMutirao("Mutirão", "desc",
                "10/09/2026 09:00", 10, 3);

        sistema.inscreverVoluntario("bruno@email.com", idAcao);
        sistema.inscreverVoluntario("aline@email.com", idAcao);

        String[] ranking = sistema.listarVoluntario();

        assertTrue(ranking[0].contains("nome='Aline'"), "Aline vem antes por ordem alfabética");
        assertTrue(ranking[1].contains("nome='Bruno'"));
    }

    @Test
    void deveLancarExcecaoParaEmailDuplicado() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Joel", "joel@email.com", "333");

        assertThrows(EmailDuplicadoException.class, () ->
                sistema.cadastrarVoluntario("Outro Nome", "joel@email.com", "444")
        );
    }
}
