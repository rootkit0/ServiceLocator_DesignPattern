package servicelocatortest;

import factories.FactoryA1;
import factories.FactoryB1;
import factories.FactoryC1;
import factories.FactoryD1;
import org.junit.jupiter.api.BeforeEach;
import servicelocator.CachedServiceLocator;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

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
}
