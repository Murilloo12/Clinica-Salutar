package br.com.murillo.salutar.controller;

import br.com.murillo.salutar.model.Midia;
import br.com.murillo.salutar.service.midia.IMidiaService;
import br.com.murillo.salutar.service.midia.MidiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MidiaController {

    @Autowired
    private IMidiaService midiaService;

    @GetMapping("/midias/{id}")
    public ResponseEntity<Midia> recuperarPeloId(@PathVariable Integer id) {
        Midia midia = midiaService.recuperarPeloId(id);
        if (midia != null) {
            return ResponseEntity.ok(midia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/midias")
    public ResponseEntity<Midia> adicionarNova(@RequestBody Midia midia) {
        Midia result = midiaService.cadastrarNova(midia);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/midias/{id}")
    public ResponseEntity<Midia> alterarDados(@PathVariable Integer id, @RequestBody Midia midia) {
        if (midia.getNumSeq() == null) {
            midia.setNumSeq(id);
        }
        Midia result = midiaService.alterarDados(midia);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/midias/{id}")
    public ResponseEntity<?> excluirMidia(@PathVariable Integer id) {
        if (midiaService.excluir(id)) {
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.notFound().build();
    }
}
