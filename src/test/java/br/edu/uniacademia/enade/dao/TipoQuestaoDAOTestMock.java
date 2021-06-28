/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.model.TipoQuestao;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author COREI7
 */
public class TipoQuestaoDAOTestMock {
    
    TipoQuestaoDAO tipoQuestaoDAO = mock(TipoQuestaoDAO.class);
    TipoQuestao tipoQuestao = mock(TipoQuestao.class);
    
    public TipoQuestaoDAOTestMock() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testAtualizar() {
        tipoQuestao = new TipoQuestao(1, "Aberta");
        
        when(tipoQuestaoDAO.atualizar(tipoQuestao)).thenReturn(tipoQuestao);
        assertEquals(tipoQuestao, tipoQuestaoDAO.atualizar(tipoQuestao));
        
    }
    
}
