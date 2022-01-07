package co.com.sofka.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.ConfirmSendMessagePage.CONFIRM_MESSAGE;

public class WasMessageSent implements Question<Boolean> {
    public static final String MESSAGE_RECEIVED = "Your message has been successfully sent to our team.";

    @Override
    public Boolean answeredBy(Actor actor) {
        return CONFIRM_MESSAGE.resolveFor(actor).getText().equals(MESSAGE_RECEIVED);
    }
    public static WasMessageSent messageWasSent(){
        return new WasMessageSent();
    }
}
