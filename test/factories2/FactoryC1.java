package factories2;

import implementations.ImplementationC1;
import interfaces.InterfaceC;
import servicelocator2.Factory;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryC1 implements Factory {
    @Override
    public InterfaceC create(ServiceLocator sl) throws LocatorError {
        try {
            String s = (String) sl.getObject(String.class);
            return new ImplementationC1(s);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
