package co.com.sofka.question;

import co.com.sofka.models.Credential;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.sofka.userinterfaces.MyAccountPage.USER_INFO_HEADER;


public class InLogin implements Question<Boolean> {
    private final Credential credential;


    public InLogin(Credential credential) {
        this.credential = credential;

    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return   USER_INFO_HEADER.resolveFor(actor).getText()
                .equals(String.format("%s %s",credential.getFirstName(),credential.getLastName()));

    }
    public static InLogin inLogin(Credential credential){
        return new InLogin(credential);
    }
}
