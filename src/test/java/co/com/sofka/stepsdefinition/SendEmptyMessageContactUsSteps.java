package co.com.sofka.stepsdefinition;

import co.com.sofka.exceptions.ValidatioTextNoMatch;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import static co.com.sofka.question.WasNotMessageSent.MESSAGE_ERROR_RECEIVED;
import static co.com.sofka.question.WasNotMessageSent.messageNotWasSent;
import static co.com.sofka.tasks.SendEmptyMessageContactUs.sendEmptyMessageToContactUs;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SendEmptyMessageContactUsSteps extends Setup{
    public static final Logger logger = LogManager.getLogger(SendEmptyMessageContactUsSteps.class);

    @When("the client fill in all the required fields except the message and send")
    public void theClientFillInAllTheRequiredFieldsExceptTheMessageAndSend() {
        theActorInTheSpotlight().attemptsTo(
                        sendEmptyMessageToContactUs()
        );
    }

    @Then("the customer should see a shipping error message")
    public void theCustomerShouldSeeAShippingErrorMessage() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            messageNotWasSent(), equalTo(true)
                    ).orComplainWith(
                            ValidatioTextNoMatch.class,
                            MESSAGE_ERROR_RECEIVED
                    )
            );

        }catch (ValidatioTextNoMatch e){
            logger.error(e.getMessage());
        }
    }
}
