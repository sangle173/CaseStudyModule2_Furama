package Commons;

public class IdCardException extends Exception {
    private String className;
    public IdCardException(String string,String className) {
        super(string);
        this.className=className;
    }

    @Override
    public String getMessage() {
        return "Input wrong:"+super.getMessage()+" at "+className;
    }
}
