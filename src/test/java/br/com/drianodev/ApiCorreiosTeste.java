package br.com.drianodev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Teste da classe {@link ApiCorreios} onde é apresentado os matchers com maior detalhes
 */
@ExtendWith(MockitoExtension.class)
public class ApiCorreiosTeste {

    @Mock
    private ApiCorreios apiCorreios;

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado() {
        when(apiCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);

        DadosLocalizacao dadosLocalizacao = apiCorreios.buscaDadosComBaseNoCep("161761");

        assertNull(dadosLocalizacao);
    }

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado2() {
        when(apiCorreios.buscaDadosComBaseNoCep("78787878")).thenReturn(new DadosLocalizacao("AM", "Manaus", "Rua Grajaúna", "casa", "Lago Azul"));

        DadosLocalizacao dadosLocalizacao = apiCorreios.buscaDadosComBaseNoCep("78787878");

        assertEquals("AM", dadosLocalizacao.getUf());
    }
}
