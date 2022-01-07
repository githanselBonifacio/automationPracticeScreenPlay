package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUsPage extends PageObject {

    public static final Target SUBJECT_HEADING = Target
            .the("Subject Heading")
            .located(By.id("id_contact"));

    public static final Target WEB_MASTER_OPTION = Target
            .the("Web Master Option")
            .located(By.xpath("//*[@id=\"id_contact\"]/option[@value=\"1\"]"));

    public static final Target CUSTOMER_SERVICE_OPTION = Target
            .the("Customer Service Option")
            .located(By.xpath("//*[@id=\"id_contact\"]/option[@value=\"2\"]"));

    public static final Target EMAIL = Target
            .the("email")
            .located(By.id("email"));

    public static final Target MESSAGE = Target
            .the("message")
            .located(By.id("message"));

    public static final Target BTN_SEND = Target
            .the("To Send")
            .located(By.id("submitMessage"));

    public static final Target MESSAGE_ERROR = Target
            .the("message error data")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
}
