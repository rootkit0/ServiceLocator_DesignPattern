package servicelocator;

import java.util.HashMap;

public class SimpleServiceLocator implements ServiceLocator {
    private HashMap<String, Factory> factories;
    private HashMap<String, Object> constants;

    public SimpleServiceLocator() {
        factories = new HashMap<>();
        constants = new HashMap<>();
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if(factories.containsKey(name) || constants.containsKey(name)) {
            throw new LocatorError("Ja hi ha una factoria enregistrada amb aquest nom!");
        }
        factories.put(name, factory);
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if(factories.containsKey(name) || constants.containsKey(name)) {
            throw new LocatorError("Ja hi ha un objecte enregistrat amb aquest nom!");
        }
        constants.put(name, value);
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if(constants.containsKey(name)) {
            return constants.get(name);
        }
        else if(factories.containsKey(name)) {
            return factories.get(name).create(this);
        }
        else {
            throw new LocatorError("No hi ha cap objecte enregistrat amb aquest nom!");
        }
    }
}
