package br.com.murillo.salutar.controller;

import br.com.murillo.salutar.model.Usuario;
import br.com.murillo.salutar.secutiry.SalutarToken;
import br.com.murillo.salutar.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> adicionarNovo(@RequestBody Usuario novo) {
        Usuario result = authService.criarUsuario(novo);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<SalutarToken> efetuarLogin(@RequestBody Usuario dadosLogin) {
        SalutarToken token = authService.realizarLogin(dadosLogin);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }
}
