package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CuentaCorrienteTest {
    private CuentaCorriente cuenta1;
    private CuentaCorriente cuenta2;
    @BeforeEach
    void setUp(){
        cuenta1 = new CuentaCorriente();
        cuenta2 = new CuentaCorriente();
    }

    @Test
    void TestPuedeExtraer(){
        cuenta1.setDescubierto(300);
        assertFalse(cuenta1.puedeExtraer(500));
        cuenta1.depositar(500);
        assertTrue(cuenta1.puedeExtraer(800));
    }

    @Test
    void TestExtraer(){
        cuenta1.setDescubierto(300);
        assertFalse(cuenta1.extraer(400));
        cuenta1.depositar(500);
        assertTrue(cuenta1.extraer(800));
    }
    @Test
    void TestTransferir(){
        assertFalse(cuenta1.transferirACuenta(100,cuenta2));
        cuenta1.depositar(500);
        cuenta1.setDescubierto(300);
        assertTrue(cuenta1.transferirACuenta(800,cuenta2));
        assertEquals(800, cuenta2.getSaldo());
    }
}
