package br.com.murillo.salutar.service.ficha;

import br.com.murillo.salutar.dao.FichaPacienteDAO;
import br.com.murillo.salutar.model.FichaPaciente;
import br.com.murillo.salutar.model.Midia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FichaServiceImpl implements IFichaService {

    @Autowired
    private FichaPacienteDAO fichaPacienteDAO;

    @Override
    public FichaPaciente cadastrar(FichaPaciente nova) {
        nova.setUuid(UUID.randomUUID().toString());
        nova.setAtivo(1);
        for (Midia midia : nova.getMidias()) {
            midia.setFicha(nova);
        }
        return fichaPacienteDAO.save(nova);
    }

    @Override
    public FichaPaciente alterar(FichaPaciente ficha) {
       FichaPaciente tmp = fichaPacienteDAO.findById(ficha.getIdFicha()).orElse(null);
       if (tmp != null) {
           if (ficha.getAtivo() != null) {
               tmp.setAtivo(ficha.getAtivo());
           }
           for (Midia midia : ficha.getMidias()) {
               midia.setFicha(ficha);
           }
           return fichaPacienteDAO.save(tmp);
       }
       return null;
    }

    @Override
    public List<FichaPaciente> buscarPeloNome(String nome) {
        return fichaPacienteDAO.findByNomePacienteContaining(nome);
    }

    @Override
    public FichaPaciente recuperarPeloId(Integer id) {
        return fichaPacienteDAO.findById(id).orElse(null);
    }

    @Override
    public boolean excluir(Integer id) {
        FichaPaciente fichaPaciente = recuperarPeloId(id);
        if (fichaPaciente != null) {
            fichaPaciente.setAtivo(0);
            fichaPacienteDAO.save(fichaPaciente);
            return true;
        }
        return false;
    }
}
