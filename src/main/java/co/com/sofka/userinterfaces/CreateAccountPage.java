package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountPage extends PageObject {

    public static final Target TITLE_MR= Target
            .the("title Mr")
            .located(By.id("id_gender1"));

    public static final Target TITLE_MRS= Target
            .the("title Mrs")
            .located(By.id("id_gender2"));

    public static final Target FIRST_NAME= Target
            .the("First Name")
            .located(By.id("customer_firstname"));

    public static final Target LAST_NAME= Target
            .the("Last Name")
            .located(By.id("customer_lastname"));

    public static final Target PASSWORD= Target
            .the("password")
            .located(By.id("passwd"));

    public static final Target ADDRESS= Target
            .the("Address")
            .located(By.id("address1"));

    public static final Target CITY= Target
            .the("City")
            .located(By.id("city"));

    public static final Target STATE= Target
            .the("state")
            .located(By.id("id_state"));


    public static final Target POSTAL_CODE= Target
            .the("Postal Code")
            .located(By.id("postcode"));

    public static final Target ADDITIONAL_INFORMATION = Target
            .the("Additional Information")
            .located(By.id("other"));

    public static final Target MOBILE_PHONE= Target
            .the("Mobile Phone")
            .located(By.id("phone_mobile"));

    public static final Target ALIAS_ADDRESS= Target
            .the("alias address")
            .located(By.id("alias"));

    public static final Target BTN_REGISTER= Target
            .the("Registrar")
            .located(By.id("submitAccount"));
}
