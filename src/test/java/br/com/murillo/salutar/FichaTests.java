package br.com.murillo.salutar;

import br.com.murillo.salutar.model.FichaPaciente;
import br.com.murillo.salutar.service.ficha.IFichaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class FichaTests {

    @Autowired
    IFichaService fichaService;

    @Test
    public void shouldCreateFichaPaciente() {
        FichaPaciente fichaPaciente = new FichaPaciente();
        fichaPaciente.setNomePaciente("Murillo");
        fichaPaciente.setIdFicha(10);
        FichaPaciente res = fichaService.cadastrar(fichaPaciente);

        assertTrue(res != null && res.getUuid() != null && res.getAtivo() == 1);
    }

    @Test
    public void shouldDeleteFicha() {
        assertTrue(fichaService.excluir(10));
    }

    @Test
    public void shouldNotDeleteFicha() {
        assertFalse(fichaService.excluir(123456));
    }

    @Test
    public void shouldReturnSeveralFicha() {
        List<FichaPaciente> lista = fichaService.buscarPeloNome("a");
        assertTrue(lista.size() > 0);
    }

    @Test
    public void shouldNotFindFicha() {
        List<FichaPaciente> lista = fichaService.buscarPeloNome("Adamastor");
        assertTrue(lista.size() == 0);
    }
}
