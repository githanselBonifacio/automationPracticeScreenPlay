package co.com.sofka.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.*;
import static co.com.sofka.userinterfaces.SignInPage.BTN_CREATE_ACCOUNT;
import static co.com.sofka.userinterfaces.SignInPage.EMAIL_CREATE;

public class GoToRegisterFormPage implements Task {
    private final String email;

    public GoToRegisterFormPage(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(email).into(EMAIL_CREATE),
                Click.on(BTN_CREATE_ACCOUNT)
        );
    }
    public static GoToRegisterFormPage registerEmail(String email){
        return new GoToRegisterFormPage(email);
    }
}
