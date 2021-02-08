package stepdefs;

import managers.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.AddComputerPage;
import managers.PageObjectManager;

public class Create_StepDef {
    WebDriver driver;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    HomePage homePage;
    AddComputerPage addComputerPage;

    @Given("I am on the computer database website")
    public void iAmOnTheComputerDatabaseWebsite() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.open_Database();
    }

    @When("I add a new computer with the details {string},{string},{string} and {string}")
    public void iAddANewComputerWithTheDetailsAnd(String cName, String iDate, String dDate, String company) throws InterruptedException {
        homePage.add_Computer_Button_Click();
        addComputerPage = pageObjectManager.getAddComputerPage();
        addComputerPage.computer_Name_Input(cName);
        addComputerPage.introduced_Date_Input(iDate);
        addComputerPage.discontinued_Date_Input(dDate);
        addComputerPage.company_Dropdown(company);
        addComputerPage.create_Computer_Button_Click();
    }

    @Then("the new computer is displayed with the details {string},{string},{string} and {string}")
    public void theNewComputerIsDisplayedWithTheDetailsAnd(String cName, String iDate, String dDate, String company) {
    }
}
