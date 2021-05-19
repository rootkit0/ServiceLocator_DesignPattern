package factories;

import implementations.ImplementationD1;
import interfaces.InterfaceD;
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

public class FactoryD1 implements Factory {
    @Override
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        try {
            int i = (Integer) sl.getObject("I");
            return new ImplementationD1(i);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
