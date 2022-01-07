package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.userinterfaces.LandingPage.CONTACT_US;

public class GoToContactUsFormPage implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONTACT_US)
        );
    }
    public static GoToContactUsFormPage AndGoToContactUsForm(){
        return new GoToContactUsFormPage();
    }
}
