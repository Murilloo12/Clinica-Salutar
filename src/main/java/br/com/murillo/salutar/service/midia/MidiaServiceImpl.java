package br.com.murillo.salutar.service.midia;

import br.com.murillo.salutar.dao.MidiaDAO;
import br.com.murillo.salutar.model.Midia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MidiaServiceImpl implements IMidiaService {

    @Autowired
    private MidiaDAO midiaDAO;

    @Override
    public Midia cadastrarNova(Midia midia) {
        return midiaDAO.save(midia);
    }

    @Override
    public Midia alterarDados(Midia midia) {
        return midiaDAO.save(midia);
    }

    @Override
    public boolean excluir(Integer id) {
        if(midiaDAO.existsById(id)){
            midiaDAO.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Midia recuperarPeloId(Integer id) {
        return midiaDAO.findById(id).orElse(null);
    }
}
