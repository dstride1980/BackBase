package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainDatabasePage;
import pages.AddComputerPage;
import managers.PageObjectManager;
import setup.Setup;
import static org.junit.Assert.*;

public class Add_a_computer_StepDef{
    private Setup setup;
    WebDriver driver;
    PageObjectManager pageObjectManager;
    MainDatabasePage mainDatabasePage;
    AddComputerPage addComputerPage;

    public Add_a_computer_StepDef(Setup setup){
        this.setup = setup;
        driver = setup.Driver();
        pageObjectManager = new PageObjectManager(driver);
        mainDatabasePage = pageObjectManager.getMainDatabasePage();
        addComputerPage = pageObjectManager.getAddComputerPage();
    }

    @Given("I am on the computer database website")
    public void iAmOnTheComputerDatabaseWebsite() {
        mainDatabasePage.open_Database();
    }

    @When("I add a new computer with the details {string},{string},{string} and {string}")
    public void iAddANewComputerWithTheDetailsAnd(String cName, String iDate, String dDate, String company) throws InterruptedException {
        mainDatabasePage.add_Computer_Button_Click();
        addComputerPage.computer_Name_Input(cName);
        addComputerPage.introduced_Date_Input(iDate);
        addComputerPage.discontinued_Date_Input(dDate);
        addComputerPage.company_Dropdown(company);
        addComputerPage.create_Computer_Button_Click();
    }

    @Then("the new computer is displayed with the details {string},{string},{string} and {string}")
    public void theNewComputerIsDisplayedWithTheDetailsAnd(String cName, String iDate, String dDate, String company) {
        var date = mainDatabasePage.format_Date(iDate, "yyyy-MM-dd");
        iDate = mainDatabasePage.format_Date(date, "dd MMM yyyy");
        date = mainDatabasePage.format_Date(dDate, "yyyy-MM-dd");
        dDate = mainDatabasePage.format_Date(date, "dd MMM yyyy");
        assertTrue( mainDatabasePage.search_Table(cName) + " does not contain " + cName, mainDatabasePage.search_Table(cName).contains(cName));
        assertTrue( mainDatabasePage.search_Table(iDate) + " does not contain " + iDate, mainDatabasePage.search_Table(iDate).contains(iDate));
        assertTrue( mainDatabasePage.search_Table(dDate) + " does not contain " + dDate, mainDatabasePage.search_Table(dDate).contains(dDate));
        assertTrue( mainDatabasePage.search_Table(company) + " does not contain " + company, mainDatabasePage.search_Table(company).contains(company));
    }
}