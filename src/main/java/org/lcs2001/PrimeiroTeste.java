package org.lcs2001;

// import org.junit.Assert; // Essa é a Assertiva do JUnit, não tão completa
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class PrimeiroTeste {

    @Test
    public void estruturaDeUmTeste() {
        // cenário
        int numero1=10, numero2=5;

        // execução
        int resultado = numero1 + numero2;

        // verificações
        // Assert.assertEquals(15, resultado); // Assertiva do JUnit
        Assertions.assertThat(resultado).isBetween(14, 16);
        Assertions.assertThat(resultado).isEqualTo(15);
        Assertions.assertThat(resultado).isGreaterThan(10);
        Assertions.assertThat(resultado).isLessThan(20);

        Assertions.assertThat("").isEmpty();
        Assertions.assertThat("Lucas").isGreaterThan("Lcs");

    }
}
