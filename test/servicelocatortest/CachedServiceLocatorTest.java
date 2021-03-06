package servicelocatortest;

import factories.FactoryA1;
import factories.FactoryB1;
import factories.FactoryC1;
import factories.FactoryD1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.CachedServiceLocator;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

import static org.junit.jupiter.api.Assertions.*;

public class CachedServiceLocatorTest {
    ServiceLocator sl;
    FactoryA1 factoryA;
    FactoryB1 factoryB;
    FactoryC1 factoryC;
    FactoryD1 factoryD;

    @BeforeEach
    public void init() throws LocatorError {
        sl = new CachedServiceLocator();
        factoryA = new FactoryA1();
        factoryB = new FactoryB1();
        factoryC = new FactoryC1();
        factoryD = new FactoryD1();

        sl.setService("A", factoryA);
        sl.setService("B", factoryB);
        sl.setService("C", factoryC);
        sl.setService("D", factoryD);
        sl.setConstant("S", "string");
        sl.setConstant("I", 1);
    }

    @Test
    public void setServiceTest(){
        String expectedMessage = "Ja hi ha una factoria enregistrada amb aquest nom!";

        // Llença excepció
        Exception exception = assertThrows(LocatorError.class, () -> {
            sl.setService("A", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService("B", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService("C", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService("D", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService("S", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService("I", factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());


        // Executa el mètode correctament
        assertDoesNotThrow(() -> {
            sl.setService("E", factoryA);
        });

        assertDoesNotThrow(() -> {
            sl.setService("F", factoryA);
        });
    }

    @Test
    public void setConstantTest(){
        String expectedMessage = "Ja hi ha un objecte enregistrat amb aquest nom!";

        // Llença excepció
        Exception exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("A", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("B", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("C", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("D", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("S", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant("I", 1);
        });
        assertEquals(expectedMessage, exception.getMessage());

        // Executa el mètode correctament
        assertDoesNotThrow(() -> {
            sl.setConstant("E", 1);
        });

        assertDoesNotThrow(() -> {
            sl.setConstant("F", 1);
        });
    }

    @Test
    public void getObjectTest() throws LocatorError {
        String expectedMessage = "No hi ha cap objecte enregistrat amb aquest nom!";

        // Executa el mètode correctament
        assertDoesNotThrow(() -> {
            sl.getObject("A");
        });
        assertDoesNotThrow(() -> {
            sl.getObject("B");
        });
        assertDoesNotThrow(() -> {
            sl.getObject("C");
        });
        assertDoesNotThrow(() -> {
            sl.getObject("D");
        });
        assertDoesNotThrow(() -> {
            sl.getObject("S");
        });
        assertDoesNotThrow(() -> {
            sl.getObject("I");
        });

        // Llença excepció
        Exception exception = assertThrows(LocatorError.class, () -> {
            sl.getObject("E");
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.getObject("F");
        });

        // Retorna el resultat correcte
        assertEquals("string", sl.getObject("S"));
        assertEquals(1, sl.getObject("I"));
    }
}
