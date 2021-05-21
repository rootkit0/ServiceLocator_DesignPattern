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
import servicelocator2.ServiceLocator;
import servicelocator2.CachedServiceLocator;
import servicelocator2.LocatorError;

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
}
