package servicelocator2;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator {
    private HashMap<Class, Factory> factories;
    private HashMap<Class, Object> constants;

    public CachedServiceLocator() {
        factories = new HashMap<>();
        constants = new HashMap<>();
    }

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if(factories.containsKey(klass) || constants.containsKey(klass)) {
            throw new LocatorError("Ja hi ha una factoria enregistrada amb aquest nom!");
        }
        factories.put(klass, factory);
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if(factories.containsKey(klass) || constants.containsKey(klass)) {
            throw new LocatorError("Ja hi ha un objecte enregistrat amb aquest nom!");
        }
        constants.put(klass, value);
    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if(constants.containsKey(klass)) {
            return (T) constants.get(klass);
        }
        else if(factories.containsKey(klass)) {
            T object = (T) factories.get(klass).create(this);
            factories.remove(klass);
            setConstant(klass, object);
            return object;
        }
        else {
            throw new LocatorError("No hi ha cap objecte enregistrat amb aquest nom!");
        }
    }
}
