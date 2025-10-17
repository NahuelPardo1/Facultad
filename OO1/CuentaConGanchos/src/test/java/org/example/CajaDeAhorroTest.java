package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    private CajaDeAhorro caja1;
    private CajaDeAhorro caja2;

    @BeforeEach
    void setUp(){
        caja1 = new CajaDeAhorro();
        caja2 = new CajaDeAhorro();
    }

    @Test
    void TestPuedeExtraer(){
        assertFalse(caja1.puedeExtraer(500));
        caja1.depositar(500);
        assertTrue(caja1.puedeExtraer(300));
        assertFalse(caja1.puedeExtraer(500));
    }

    @Test
    void TestExtraer(){
        assertFalse(caja1.extraer(100));
        caja1.depositar(510);
        assertTrue(caja1.extraer(500));
    }
    @Test
    void TestTransferir(){
        assertFalse(caja1.transferirACuenta(100,caja2));
        caja1.depositar(510);
        assertTrue(caja1.transferirACuenta(500,caja2));
        assertEquals(500, caja2.getSaldo());
    }

}
