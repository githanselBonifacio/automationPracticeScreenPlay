package co.com.sofka.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAccountPage extends PageObject {

    public static final Target USER_INFO_HEADER = Target
            .the("Information user")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));

}
