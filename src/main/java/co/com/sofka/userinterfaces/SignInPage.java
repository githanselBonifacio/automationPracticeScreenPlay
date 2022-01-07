package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage extends PageObject {

    public static final Target EMAIL_CREATE = Target
            .the("email for register")
            .located(By.id("email_create"));

    public static final Target EMAIL_LOGIN = Target
            .the("email for login")
            .located(By.id("email"));

    public static final Target PASSWORD = Target
            .the("password")
            .located(By.id("passwd"));

    public static final Target BTN_CREATE_ACCOUNT = Target
            .the("create account")
            .located(By.id("SubmitCreate"));

    public static final Target BTN_SIGN_IN= Target
            .the("sgn in")
            .located(By.id("SubmitLogin"));
}
