package Commons;

public class NameException extends Exception {
    private final String className;

    public NameException(String string, String className) {
        super(string);
        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Input wrong:" + super.getMessage() + " at " + className;
    }
}
