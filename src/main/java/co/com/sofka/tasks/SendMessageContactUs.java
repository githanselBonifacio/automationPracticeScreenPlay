package co.com.sofka.tasks;

import co.com.sofka.utils.ChoiseOption;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import static co.com.sofka.userinterfaces.ContactUsPage.*;
import static co.com.sofka.utils.ChoiseOption.choiseOption;

public class SendMessageContactUs implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        ChoiseOption remitter = choiseOption(new Target[]{WEB_MASTER_OPTION,CUSTOMER_SERVICE_OPTION});
        actor.attemptsTo(
                Click.on(SUBJECT_HEADING),

                Click.on((Target) remitter.selectOptionRandon()),

                Enter.theValue(faker.internet().emailAddress()).into(EMAIL),

                Enter.theValue(faker.lorem().paragraph()).into(MESSAGE),

                Click.on(BTN_SEND)
        );
    }


    public static SendMessageContactUs sendMessageContactUs (){return new SendMessageContactUs();}
}
