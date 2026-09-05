package impacta;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class PontuacaoTest {

    @Test
    void plantioDeveCalcularBasePorMuda() {
        Plantio p = new Plantio(1, "Plantio Teste", "descrição",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 3);

        assertEquals(5 + 2 * 3, p.calcularPontuacao());
    }

    @Test
    void mutiraoDeveCalcularPorHora() {
        Mutirao m = new Mutirao(2, "Mutirão Teste", "descrição",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 4);

        assertEquals(4 * 4, m.calcularPontuacao());
    }

    @Test
    void oficinaComKitDeveSomarBonus() {
        Oficina o = new Oficina(3, "Oficina Teste", "descrição",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 2, true);

        assertEquals(3 * 2 + 10, o.calcularPontuacao());
    }

    @Test
    void oficinaSemKitNaoDeveSomarBonus() {
        Oficina o = new Oficina(4, "Oficina Teste 2", "descrição",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 2, false);

        assertEquals(3 * 2, o.calcularPontuacao());
    }

    @Test
    void calculoDevePermanecerPolimorficoViaClasseBase() {
        AcaoSocioambiental plantio = new Plantio(5, "t", "d",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 1);
        AcaoSocioambiental mutirao = new Mutirao(6, "t", "d",
                LocalDateTime.of(2026, 9, 10, 9, 0), 10, 1);

        assertEquals(7, plantio.calcularPontuacao());
        assertEquals(4, mutirao.calcularPontuacao());
        assertNotEquals(plantio.calcularPontuacao(), mutirao.calcularPontuacao());
    }
}
