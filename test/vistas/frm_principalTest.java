/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Remmi
 */
public class frm_principalTest {

    public frm_principalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of activaOpciones method, of class frm_principal.
     */
    @Test
    public void testActivaOpciones() {
        System.out.println("activaOpciones");
        int bandera = 0;
        frm_principal instance = new frm_principal();
        instance.activaOpciones(bandera);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class frm_principal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        frm_principal.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}