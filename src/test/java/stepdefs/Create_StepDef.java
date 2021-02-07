package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_StepDef {
    @Given("I am on the computer database website")
    public void iAmOnTheComputerDatabaseWebsite() {
    }

    @When("I add a new computer with the details {string},{string},{string} and {string}")
    public void iAddANewComputerWithTheDetailsComputer_nameIntroducedDiscontinuedAndCompany() {
    }

    @Then("the new computer is displayed with the details {string},{string},{string} and {string}")
    public void theNewComputerIsDisplayedWithTheDetailsComputer_nameIntroducedDiscontinuedAndCompany() {
    }
}
