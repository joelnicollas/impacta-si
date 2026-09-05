package impacta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImpactaIntegracaoTest {

    @Test
    void deveInscreverVoluntarioComSucesso() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Miguel", "miguel@email.com", "555");
        int idAcao = sistema.cadastrarMutirao("Limpeza da Praia", "Coleta de resíduos",
                "15/09/2026 08:00", 5, 3);

        boolean resultado = sistema.inscreverVoluntario("miguel@email.com", idAcao);

        assertTrue(resultado);
        String detalhes = sistema.exibirDetalhesAcao(idAcao);
        assertTrue(detalhes.contains("Miguel"));
        assertTrue(detalhes.contains("Mutirão de Reciclagem"));
    }

    @Test
    void deveLancarExcecaoQuandoAcaoLotada() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Rodrigo", "rodrigo@email.com", "666");
        sistema.cadastrarVoluntario("Joao", "joao@email.com", "777");

        int idAcao = sistema.cadastrarOficina("Oficina de Compostagem", "desc",
                "20/09/2026 14:00", 1, 2, true);

        sistema.inscreverVoluntario("rodrigo@email.com", idAcao);

        assertThrows(AcaoLotadaException.class, () ->
                sistema.inscreverVoluntario("joao@email.com", idAcao)
        );
    }

    @Test
    void deveLancarExcecaoParaInscricaoDuplicada() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Ana", "ana2@email.com", "888");

        int idAcao = sistema.cadastrarPlantio("Plantio no Parque", "desc",
                "25/09/2026 09:00", 10, 5);

        sistema.inscreverVoluntario("ana2@email.com", idAcao);

        assertThrows(InscricaoDuplicadaException.class, () ->
                sistema.inscreverVoluntario("ana2@email.com", idAcao)
        );
    }

    @Test
    void fluxoCompletoDeveAtualizarPontuacaoDoVoluntario() {
        Impacta sistema = new Impacta();
        sistema.cadastrarVoluntario("Beatriz", "beatriz@email.com", "999");

        int idPlantio = sistema.cadastrarPlantio("Plantio", "desc",
                "01/10/2026 09:00", 10, 2);

        sistema.inscreverVoluntario("beatriz@email.com", idPlantio);

        String voluntarioExibido = sistema.exibirVoluntario("beatriz@email.com");
        assertTrue(voluntarioExibido.contains("quantidadeAcoes=1"));
        assertTrue(voluntarioExibido.contains("pontuacao=9"));
    }
}
