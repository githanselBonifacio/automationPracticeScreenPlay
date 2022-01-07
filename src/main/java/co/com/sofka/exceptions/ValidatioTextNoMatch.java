package co.com.sofka.exceptions;

public class ValidatioTextNoMatch extends AssertionError{
    private final String text;
    public static final String VALIDATION_DO_NOT_MATCH = "The validation don't match. %s";

    public ValidatioTextNoMatch(String text, String message, Throwable cause){
        super(message, cause);
        this.text=text;
    }

    @Override
    public String getMessage(){
        return String.format(VALIDATION_DO_NOT_MATCH,text);
    }

}
