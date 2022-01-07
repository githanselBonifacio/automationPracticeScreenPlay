package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LandingPage extends PageObject {

    public static final Target CONTACT_US = Target
            .the("Contact us")
            .located(By.id("contact-link"));

    public static final Target SIGN_IN = Target
            .the("Sign in")
            .located(By.className("login"));
}
