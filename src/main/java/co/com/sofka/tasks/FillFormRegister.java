package co.com.sofka.tasks;

import co.com.sofka.models.Account;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.By;

import static co.com.sofka.userinterfaces.CreateAccountPage.*;


public class FillFormRegister implements Task {
    private final Account account;

    public FillFormRegister(Account account) {
        this.account = account;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String xpathStateOption = String.format("//option[contains(text(),\"%s\")]",account.getState());
        actor.attemptsTo(
                Check.whether(account.getTitle().getValue()==1)
                        .andIfSo(
                                Click.on(TITLE_MR)

                        ).otherwise(
                                Click.on(TITLE_MRS)
                        ),

                Enter.theValue(account.getFirstName()).into(FIRST_NAME),

                Enter.theValue((account.getLastName())).into(LAST_NAME),

                Enter.theValue(account.getPassword()).into(PASSWORD),

                Enter.theValue(account.getAddress()).into(ADDRESS),

                Enter.theValue(account.getCity()).into(CITY),

                Click.on(STATE),

                Scroll.to(By.xpath(xpathStateOption)),
                Click.on(By.xpath(xpathStateOption)),

                Enter.theValue(account.getPostalCode()).into(POSTAL_CODE),

                Enter.theValue(account.getAditionalInformation()).into(ADDITIONAL_INFORMATION),

                Enter.theValue(account.getMobilePhone()).into(MOBILE_PHONE),

                Enter.theValue(account.getAddressAlias()).into(ALIAS_ADDRESS),

               Click.on(BTN_REGISTER)

        );
    }
    public static FillFormRegister fillFormRegister(Account account){return new FillFormRegister(account);}
}
