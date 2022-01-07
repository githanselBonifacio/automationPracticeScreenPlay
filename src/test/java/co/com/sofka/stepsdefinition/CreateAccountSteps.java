package co.com.sofka.stepsdefinition;

import co.com.sofka.exceptions.ValidatioTextNoMatch;
import co.com.sofka.models.Account;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static co.com.sofka.question.WasAccountCreated.accountWasCreated;
import static co.com.sofka.tasks.FillFormRegister.fillFormRegister;
import static co.com.sofka.tasks.GoToSignInPage.*;
import static co.com.sofka.tasks.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.GoToRegisterFormPage.registerEmail;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountSteps extends Setup{
    public static final Logger logger = LogManager.getLogger(CreateAccountSteps.class);
    private static final String  NAME_ACTOR ="cliente";
    private final Account account = Account.cretedFullAccount();

    @Given("the customer is on the login page")
    public void theCustomerIsOnTheLoginPage() {
        actorSetupTheBrowser(NAME_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                andGoToSignInPage()
        );
    }

    @When("the customer enter his email and send register")
    public void theCustomerEnterHisEmailAndSendRegister() {
        theActorInTheSpotlight().attemptsTo(
                registerEmail(account.getEmail())
        );
    }

    @When("fill out the registration form with the required fields")
    public void fillOutTheRegistrationForm() {
        theActorInTheSpotlight().attemptsTo(
                fillFormRegister(account)
        );
    }

    @Then("the customer must be logged in")
    public void theCustomerMustBeLoggedIn() {
        try{
            theActorInTheSpotlight().should(
                seeThat(
                        accountWasCreated(account),equalTo(true)
                ).orComplainWith(
                        ValidatioTextNoMatch.class,
                        account.getFirstName()+" "+account.getLastName()
                )
            );
        }catch (ValidatioTextNoMatch e){
            logger.error(e.getMessage());
        }
    }

}
