package org.lcs2001;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        // cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        // verificação
        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        // cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucas");

        // execução
        cadastroPessoas.adicionar(pessoa);

        // verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test (expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio() {
        // Cenário
        CadastroPessoas cadastroPessoa = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execução
        cadastroPessoa.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {
        // Cenário
        CadastroPessoas cadastroPessoa = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Márcio");
        cadastroPessoa.adicionar(pessoa);

        // execução
        cadastroPessoa.remover(pessoa);

        // verificação
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test (expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        // Cenário
        CadastroPessoas cadastroPessoa = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastroPessoa.remover(pessoa);
    }

}
