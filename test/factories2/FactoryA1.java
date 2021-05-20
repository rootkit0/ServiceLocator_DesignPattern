package factories2;

import implementations.ImplementationA1;
import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import servicelocator2.Factory;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryA1 implements Factory {
    @Override
    public InterfaceA create(ServiceLocator sl) throws LocatorError {
        try {
            InterfaceB b = (InterfaceB) sl.getObject(InterfaceB.class);
            InterfaceC c = (InterfaceC) sl.getObject(InterfaceC.class);
            return new ImplementationA1(b, c);
        }
        catch(ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
