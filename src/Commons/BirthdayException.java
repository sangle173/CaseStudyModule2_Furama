package Commons;

public class BirthdayException extends Exception {
    private final String className;

    public BirthdayException(String string, String className) {
        super(string);
        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Input wrong:" + super.getMessage() + " at " + className;
    }
}
