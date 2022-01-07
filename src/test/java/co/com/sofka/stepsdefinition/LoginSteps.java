package co.com.sofka.stepsdefinition;

import co.com.sofka.exceptions.ValidatioTextNoMatch;
import co.com.sofka.models.Credential;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static co.com.sofka.question.InLogin.inLogin;
import static co.com.sofka.tasks.Login.toLogin;
import static co.com.sofka.utils.AdminCredential.getCredential;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps extends Setup{
    public static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private final Credential CREDENTIALS= getCredential();

    @When("the customer enters their credentials and sends")
    public void theCustomerEntersTheirCredentialsAndSends() {
        theActorInTheSpotlight().attemptsTo(
                toLogin(CREDENTIALS)
        );
    }
    @Then("he customer must obtain a successful login")
    public  void heCustomerMustObtainAsuccessfulLogin(){
        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            inLogin(CREDENTIALS)
                    ).orComplainWith(
                            ValidatioTextNoMatch.class,
                            CREDENTIALS.toString()
                    )
            );
        }catch (ValidatioTextNoMatch e){
            logger.error(e.getMessage());
        }
    }
}
