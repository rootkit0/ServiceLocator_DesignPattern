package factories;

import implementations.ImplementationC1;
import interfaces.InterfaceC;
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

public class FactoryC1 implements Factory {
    @Override
    public InterfaceC create(ServiceLocator sl) throws LocatorError {
        try {
            String s = (String) sl.getObject("S");
            return new ImplementationC1(s);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
