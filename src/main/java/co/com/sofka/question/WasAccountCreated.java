package co.com.sofka.question;

import co.com.sofka.models.Account;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.MyAccountPage.USER_INFO_HEADER;
import static co.com.sofka.utils.AdminCredential.uptateAccessCredentialUser;


public class WasAccountCreated implements Question<Boolean> {
    private final Account account;


    public WasAccountCreated(Account account) {
        this.account = account;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean answer = USER_INFO_HEADER.resolveFor(actor).getText()
                .equals(String.format("%s %s",account.getFirstName(),account.getLastName()));

        if(Boolean.TRUE.equals(answer)){
            uptateAccessCredentialUser(account);
        }
        return answer;
    }
    public static WasAccountCreated accountWasCreated(Account account){
        return new WasAccountCreated(account);
    }
}
