package Commons;

public class EmailException extends Exception {
    private String className;

    public EmailException(String string, String className) {
        super(string);
        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Input wrong:" + super.getMessage() + " at " + className;
    }
}
