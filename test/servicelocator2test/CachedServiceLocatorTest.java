package servicelocator2test;

import factories2.FactoryA1;
import factories2.FactoryB1;
import factories2.FactoryC1;
import factories2.FactoryD1;
import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import interfaces.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator2.ServiceLocator;
import servicelocator2.CachedServiceLocator;
import servicelocator2.LocatorError;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        sl.setService(InterfaceA.class, factoryA);
        sl.setService(InterfaceB.class, factoryB);
        sl.setService(InterfaceC.class, factoryC);
        sl.setService(InterfaceD.class, factoryD);
        sl.setConstant(String.class, "string");
        sl.setConstant(int.class, 1);
    }

    @Test
    public void setService(){
        String expectedMessage = "Ja hi ha una factoria enregistrada amb aquest nom!";

        // Llença excepció
        Exception exception = assertThrows(LocatorError.class, () -> {
            sl.setService(InterfaceA.class, factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService(InterfaceB.class, factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService(InterfaceC.class, factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setService(InterfaceD.class, factoryA);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setConstant(){
        String expectedMessage = "Ja hi ha un objecte enregistrat amb aquest nom!";

        // Llença excepció
        Exception exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant(String.class, "A");
        });
        assertEquals(expectedMessage, exception.getMessage());

        exception = assertThrows(LocatorError.class, () -> {
            sl.setConstant(int.class, 1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getObject() throws LocatorError {
        // Executa el mètode correctament
        /*assertDoesNotThrow(() -> {
            sl.getObject(InterfaceA.class);
        });
        assertDoesNotThrow(() -> {
            sl.getObject(InterfaceB.class);
        });
        assertDoesNotThrow(() -> {
            sl.getObject(InterfaceC.class);
        });
        assertDoesNotThrow(() -> {
            sl.getObject(InterfaceD.class);
        });*/
        assertDoesNotThrow(() -> {
            sl.getObject(String.class);
        });
        assertDoesNotThrow(() -> {
            sl.getObject(int.class);
        });

        // Retorna el resultat correcte
        assertEquals("string", sl.getObject(String.class));
        assertEquals(1, sl.getObject(int.class));
    }
}
