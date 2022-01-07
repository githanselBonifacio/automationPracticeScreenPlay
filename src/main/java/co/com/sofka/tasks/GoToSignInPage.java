package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.userinterfaces.LandingPage.SIGN_IN;

public class GoToSignInPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SIGN_IN)
        );
    }
    public static GoToSignInPage andGoToSignInPage(){return new GoToSignInPage();}
}
