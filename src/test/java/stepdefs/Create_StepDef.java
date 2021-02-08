package stepdefs;

import browser.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Create_StepDef {
    WebDriver driver;
    WebDriverManager webDriverManager;

    @Given("I am on the computer database website")
    public void iAmOnTheComputerDatabaseWebsite() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
    }

    @When("I add a new computer with the details {string},{string},{string} and {string}")
    public void iAddANewComputerWithTheDetailsAnd(String arg0, String arg1, String arg2, String arg3) {
    }

    @Then("the new computer is displayed with the details {string},{string},{string} and {string}")
    public void theNewComputerIsDisplayedWithTheDetailsAnd(String arg0, String arg1, String arg2, String arg3) {
    }
}
