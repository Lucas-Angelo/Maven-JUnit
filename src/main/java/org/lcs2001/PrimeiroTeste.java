package org.lcs2001;

// import org.junit.Assert; // Essa é a Assertiva do JUnit, não tão completa
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class PrimeiroTeste {

    Calculadora calculadora;

    @Before //Antes de cada método dessa classe, executa esse método Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros() {
        // cenário
        double numero1=10, numero2=5;

        // execução
        double resultado = calculadora.somar(numero1, numero2);

        // verificações
        // Assert.assertEquals(15, resultado); // Assertiva do JUnit
        Assertions.assertThat(resultado).isEqualTo(15);

        /*
        Outras assertivas de Teste AssertJ
        Assertions.assertThat(resultado).isBetween(14, 16);
        Assertions.assertThat(resultado).isGreaterThan(10);
        Assertions.assertThat(resultado).isLessThan(20);

        Assertions.assertThat("").isEmpty();
        Assertions.assertThat("Lucas").isGreaterThan("Lcs");
        */
    }

    @Test
    public void deveSubtrair2Numeros() {
        // cenário
        double numero1=-15, numero2=5.5;

        // execução
        double resultado = calculadora.subtrair(numero1, numero2);

        // verificações
        Assertions.assertThat(resultado).isEqualTo(-20.5);
    }

    @Test
    public void deveMultiplicar2Numeros() {
        // cenário
        double numero1=5, numero2=-5;

        // execução
        double resultado = calculadora.multiplicar(numero1, numero2);

        // verificações
        Assertions.assertThat(resultado).isEqualTo(-25);
    }

    @Test
    public void deveDividirDoisNumeros() {
        // cenário
        double numero1=-10, numero2=5;

        // execução
        double resultado = calculadora.dividir(numero1, numero2);

        // verificações
        Assertions.assertThat(resultado).isEqualTo(-2);
    }

    @Test (expected = RuntimeException.class) // Para não dar erro, já se é esperado retornar uma execessão de dividir por zero
    public void naoDeveDividirPorZero() {
        // cenário
        int numero1=10, numero2=0;

        calculadora.dividir(numero1, numero2);
    }
}

class Calculadora {

    double somar(double num1, double num2) {
        return num1+num2;
    }

    double subtrair(double num1, double num2) {
        return num1-num2;
    }

    double multiplicar(double num1, double num2) {
        return num1*num2;
    }

    double dividir(double num1, double num2) {
        if(num2==0)
            throw new RuntimeException("Não é possível dividir por zero!");
        else
            return num1/num2;
    }

}
