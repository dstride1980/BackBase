package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.EditComputerPage;
import pages.MainDatabasePage;
import setup.Setup;

import static org.junit.Assert.*;

public class Delete_a_computer_StepDef {
    MainDatabasePage mainDatabasePage;
    EditComputerPage editComputerPage;
    PageObjectManager pageObjectManager;
    WebDriver driver;
    private Setup setup;

    public Delete_a_computer_StepDef(Setup setup){
        this.setup = setup;
        driver = setup.Driver();
        pageObjectManager = new PageObjectManager(driver);
        mainDatabasePage = pageObjectManager.getMainDatabasePage();
        editComputerPage = pageObjectManager.getEditComputerPage();
    }

    @When("I delete the computer {string}")
    public void iDeleteTheComputer(String cName) {
        mainDatabasePage.computer_Name_Link_Click(cName);
        editComputerPage.delete_This_Computer_Button_Click();
    }

    @Then("the details of the computer {string} are removed from Database")
    public void theDetailsOfTheComputerAreRemovedFromDatabase(String cName) {
        assertNull(cName + " has not been deleted from database",mainDatabasePage.search_Table(cName));
    }
}