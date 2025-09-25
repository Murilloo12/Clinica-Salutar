package br.com.murillo.salutar.controller;

import br.com.murillo.salutar.model.FichaPaciente;
import br.com.murillo.salutar.service.ficha.IFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class FichaController {

    @Autowired
    private IFichaService fichaService;

    @GetMapping("/fichas/busca")
    public ResponseEntity<List<FichaPaciente>> recuperarPeloNome(@RequestParam(name = "nome") String nome) {
        List<FichaPaciente> lista = fichaService.buscarPeloNome(nome);
        if (lista.size() > 0) {
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/fichas")
    public ResponseEntity<FichaPaciente> cadastrarNovaFicha(@RequestBody FichaPaciente nova) throws Exception {
        FichaPaciente result = fichaService.cadastrar(nova);
        if (result != null) {
            return ResponseEntity.created(new URI("/fichas/" + result.getIdFicha())).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> buscarPeloId(@PathVariable Integer id) {
        FichaPaciente result = fichaService.recuperarPeloId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> alterarFicha(@RequestBody FichaPaciente ficha, @PathVariable Integer id) {
        if (ficha.getIdFicha() == null) {
            ficha.setIdFicha(id);
        }
        FichaPaciente result = fichaService.alterar(ficha);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> excluirFicha(@PathVariable Integer id) {
        boolean result = fichaService.excluir(id);
        if (result) {
            return ResponseEntity.ok(fichaService.recuperarPeloId(id));
        }
        return ResponseEntity.notFound().build();
    }
}
