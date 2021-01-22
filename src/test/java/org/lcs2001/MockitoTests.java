package org.lcs2001;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoTests {

    @Test
    public void primeiroTesteMockito() {
        List<String> lista = Mockito.mock(ArrayList.class); // Instância uma lista utilizando o Mockito

        Mockito.when( lista.size() ).thenReturn(20); // Toda return do tamanho dessa instância de lista mockito retorna que possui 20 elementos

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);
    }

    @Test
    public void segundoTesteMockito() {
        List<String> lista = Mockito.mock(ArrayList.class);
        lista.add("Elemento 0");
        lista.add("Elemento 1");

        // Mockito.when( lista.size() ).thenReturn(20);

        int size = lista.size(); // Vai retornar zero pois se não altera o tamanho pelo Mockito, não muda

        Assertions.assertThat(size).isEqualTo(0);
    }
}
