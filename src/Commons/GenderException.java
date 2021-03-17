package Commons;

public class GenderException extends Exception{
    private String className;
    public GenderException(String string,String className) {
        super(string);
        this.className=className;
    }

    @Override
    public String getMessage() {
        return "Input wrong:"+super.getMessage()+" at "+className;
    }
}
