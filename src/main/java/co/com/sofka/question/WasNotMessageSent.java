package co.com.sofka.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.sofka.userinterfaces.ContactUsPage.MESSAGE_ERROR;
public class WasNotMessageSent implements Question<Boolean> {
    public static final String MESSAGE_ERROR_RECEIVED = "The message cannot be blank.";

    @Override
    public Boolean answeredBy(Actor actor) {
        return MESSAGE_ERROR.resolveFor(actor).getText().equals(MESSAGE_ERROR_RECEIVED);
    }
    public static WasNotMessageSent messageNotWasSent(){
        return new WasNotMessageSent();
    }
}
