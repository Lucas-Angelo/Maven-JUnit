package org.lcs2001;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        if(pessoa.getNome() == null)
            throw new PessoaSemNomeException();
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if (!this.pessoas.contains(pessoa))
            throw new CadastroVazioException();
        this.pessoas.remove(pessoa);
    }
}
