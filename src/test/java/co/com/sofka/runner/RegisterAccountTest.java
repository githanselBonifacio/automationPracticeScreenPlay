package co.com.sofka.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/sinIn.feature"},
        glue = {"co.com.sofka.stepsdefinition"},
        tags = {"not @ingnore"}
)
public class RegisterAccountTest {
}
