package br.com.murillo.salutar.dao;

import br.com.murillo.salutar.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);
}
