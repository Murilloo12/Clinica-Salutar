package br.com.murillo.salutar.service.auth;

import br.com.murillo.salutar.dao.UsuarioDAO;
import br.com.murillo.salutar.model.Usuario;
import br.com.murillo.salutar.secutiry.SalutarToken;
import br.com.murillo.salutar.secutiry.TokenUtil;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario criarUsuario(Usuario novo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String novaSenha = encoder.encode(novo.getSenha());
        novo.setSenha(novaSenha);
        return usuarioDAO.save(novo);
    }

    @Override
    public SalutarToken realizarLogin(Usuario dadosLogin) {
        Usuario result = usuarioDAO.findByLogin(dadosLogin.getLogin());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (result != null) {
            if (encoder.matches(dadosLogin.getSenha(), result.getSenha())) {
                return TokenUtil.encode(result);
            }
        }
        return null;
    }
}
