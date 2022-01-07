package co.com.sofka.tasks;

import co.com.sofka.models.Credential;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.userinterfaces.SignInPage.*;

public class Login implements Task {
    private final Credential credential;


    public Login(Credential credential) {
        this.credential = credential;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credential.getEmail()).into(EMAIL_LOGIN),
                Enter.theValue(credential.getPassword()).into(PASSWORD),
                Click.on(BTN_SIGN_IN)
        );
    }
    public static Login toLogin(Credential credential){
        return new Login(credential);
    }
}
