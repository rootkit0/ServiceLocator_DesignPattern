package factories2;

import implementations.ImplementationB1;
import interfaces.InterfaceB;
import interfaces.InterfaceD;
import servicelocator2.Factory;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryB1 implements Factory {
    @Override
    public InterfaceB create(ServiceLocator sl) throws LocatorError {
        try {
            InterfaceD d = (InterfaceD) sl.getObject(InterfaceD.class);
            return new ImplementationB1(d);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
