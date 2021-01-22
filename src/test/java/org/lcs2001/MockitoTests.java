package org.lcs2001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    List<String> lista; // Instância de lista Mockito

    @Test
    public void primeiroTesteMockito() {
        Mockito.when( lista.size() ).thenReturn(20); // Toda return do tamanho dessa instância de lista mockito retorna que possui 20 elementos

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);
    }

    @Test
    public void segundoTesteMockito() {
        List<String> list = Mockito.mock(ArrayList.class); // Outra forma de declarar uma lista Mockito
        list.add("Elemento 0");
        list.add("Elemento 1");

        // Mockito.when( lista.size() ).thenReturn(20);

        int size = list.size(); // Vai retornar zero pois se não altera o tamanho pelo Mockito, não muda

        Assertions.assertThat(size).isEqualTo(0);
    }

    @Test
    public void terceiroTesteMockito() {
        List<String> list = Mockito.mock(ArrayList.class);

        list.size();

        Mockito.verify(list, Mockito.times(1)).size(); // verify() para verificar se já foi utilizado o .size()
        Mockito.verify(list, Mockito.never()).isEmpty(); // verify() para verificar se já foi utilizado o .size()
    }

    @Test
    public void quartoTesteMockito() {
        List<String> list = Mockito.mock(ArrayList.class);

        // Se alterar a ordem desses dois comandos, retorna erro
        list.size();
        list.add("");

        // Verificar se esses comandos foram executados exatamente nessa ordem para essa lista
        InOrder inOrder = Mockito.inOrder(list);
        inOrder.verify(list).size();
        inOrder.verify(list).add("");
    }
}
