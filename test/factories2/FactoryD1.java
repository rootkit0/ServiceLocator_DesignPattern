package factories2;

import implementations.ImplementationD1;
import interfaces.InterfaceD;
import servicelocator2.Factory;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryD1 implements Factory {
    @Override
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        try {
            int i = (Integer) sl.getObject(Integer.class);
            return new ImplementationD1(i);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
