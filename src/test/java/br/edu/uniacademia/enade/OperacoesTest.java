/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author COREI7
 */
public class OperacoesTest {

    Operacoes operacoes = null;

    public OperacoesTest() {
    }

    @Before
    public void setUp() {
        operacoes = new Operacoes();
    }

    @Test
    public void testSoma() {

        assertEquals(0, operacoes.soma(0, 0));

    }

    @Test
    public void testSub() {

        assertEquals(1, operacoes.sub(3, 2));

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
