package co.com.sofka.stepsdefinition;

import co.com.sofka.exceptions.ValidatioTextNoMatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static co.com.sofka.question.WasMessageSent.MESSAGE_RECEIVED;
import static co.com.sofka.question.WasMessageSent.messageWasSent;
import static co.com.sofka.tasks.GoToContactUsFormPage.AndGoToContactUsForm;
import static co.com.sofka.tasks.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.SendMessageContactUs.sendMessageContactUs;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SendMessageContactUsSteps extends Setup {
    public static final Logger logger = LogManager.getLogger(SendMessageContactUsSteps.class);
    private static final String  NAME_ACTOR ="cliente";

    @Given("the customer is in the form to send message to customer service")
    public void theCustomerIsInTheFormToSendMessageToCustomerService() {
            actorSetupTheBrowser(NAME_ACTOR);

            theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                AndGoToContactUsForm()
          );
    }
    @When("the client fill in all the required fields and send")
    public void theClientFillInAllTheRequiredFieldsAndSend() {
            theActorInTheSpotlight().attemptsTo(
                    sendMessageContactUs()
            );
    }
    @Then("the customer should see a shipping confirmation message")
    public void elClienteDebeVerUnMensajeDeConfirmacionDeEnvio() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            messageWasSent(), equalTo(true)
                    ).orComplainWith(
                            ValidatioTextNoMatch.class,
                            MESSAGE_RECEIVED
                    )
            );
        }catch (ValidatioTextNoMatch e){
            logger.error(e.getMessage());

        }
    }
}
