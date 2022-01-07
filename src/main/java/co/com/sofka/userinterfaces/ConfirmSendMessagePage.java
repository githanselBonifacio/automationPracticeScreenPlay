package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmSendMessagePage extends PageObject {

    public static final Target CONFIRM_MESSAGE = Target
            .the("confirmation message")
            .located(By.xpath("//p[@class=\"alert alert-success\"]"));
}
