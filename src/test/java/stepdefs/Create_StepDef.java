package stepdefs;

import managers.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import managers.PageObjectManager;

public class Create_StepDef {
    WebDriver driver;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    HomePage homePage;

    @Given("I am on the computer database website")
    public void iAmOnTheComputerDatabaseWebsite() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.open_Database();
    }

    @When("I add a new computer with the details {string},{string},{string} and {string}")
    public void iAddANewComputerWithTheDetailsAnd(String arg0, String arg1, String arg2, String arg3) {
    }

    @Then("the new computer is displayed with the details {string},{string},{string} and {string}")
    public void theNewComputerIsDisplayedWithTheDetailsAnd(String arg0, String arg1, String arg2, String arg3) {
    }
}
