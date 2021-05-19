package servicelocator2;

public class LocatorError extends Exception {
    public LocatorError(String msg) {
        super(msg);
    }
    public LocatorError(ClassCastException ex) {
        super(ex);
    }
}
