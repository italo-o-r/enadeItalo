/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author COREI7
 */
public class OperacoesTestMock {

    Operacoes operacoes = mock(Operacoes.class);

    public OperacoesTestMock() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSoma() {

        when(operacoes.soma(anyInt(), anyInt())).thenReturn(2);
        assertEquals(2, operacoes.soma(anyInt(), anyInt()));

    }

    @Test
    public void testSub() {

        assertEquals(1, operacoes.sub(0, 0));

    }

    @Test
    public void testDiv() {

        assertEquals(2, operacoes.div(4, 2));

    }

    @Test
    public void testMult() {

        assertEquals(0, operacoes.mult(0, 0));

    }

}
