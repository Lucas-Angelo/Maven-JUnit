package org.lcs2001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas(){
        // cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        // verificação
        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa na lista")
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

    @Test
    @DisplayName("Não deve deixar adicionar pessoas com nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio() {
        // Cenário
        CadastroPessoas cadastroPessoa = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                PessoaSemNomeException.class, () -> cadastroPessoa.adicionar(pessoa)
        );
    }

    @Test
    @DisplayName("Deve remover uma pessoa")
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

    @Test
    @DisplayName("Deve lançar um erro ao tentar remover uma pessoas inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        // Cenário
        CadastroPessoas cadastroPessoa = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                CadastroVazioException.class, () -> cadastroPessoa.remover(pessoa)
        );
    }

}
