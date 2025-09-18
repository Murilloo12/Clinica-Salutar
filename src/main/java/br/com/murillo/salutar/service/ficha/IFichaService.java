package br.com.murillo.salutar.service.ficha;

import br.com.murillo.salutar.model.FichaPaciente;

import java.util.List;

public interface IFichaService {

    public FichaPaciente cadastrar(FichaPaciente nova);

    public FichaPaciente alterar(FichaPaciente ficha);

    public List<FichaPaciente> buscarPeloNome(String nome);

    public FichaPaciente recuperarPeloId(Integer id);

    public boolean excluir(Integer id);
}
