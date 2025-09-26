package br.com.murillo.salutar.service.auth;

import br.com.murillo.salutar.model.Usuario;
import br.com.murillo.salutar.secutiry.SalutarToken;

public interface IAuthService {

    public Usuario criarUsuario(Usuario novo);
    public SalutarToken realizarLogin(Usuario dadosLogin);
}
