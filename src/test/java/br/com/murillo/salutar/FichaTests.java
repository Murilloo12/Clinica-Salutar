package br.com.murillo.salutar;

import br.com.murillo.salutar.model.FichaPaciente;
import br.com.murillo.salutar.service.ficha.IFichaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
        FichaPaciente res = fichaService.cadastrar(fichaPaciente);

        assertTrue(res != null && res.getUuid() != null && res.getAtivo() == 1);
    }

    @Test
    public void shouldDeleteFicha() {
        assertTrue(fichaService.excluir(1));
    }

    @Test
    public void shouldNotDeleteFicha() {
        assertFalse(fichaService.excluir(123456));
    }
}
