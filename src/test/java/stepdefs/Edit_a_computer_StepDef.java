package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.AddComputerPage;
import pages.EditComputerPage;
import pages.HeaderPage;
import pages.MainDatabasePage;
import setup.Setup;
import static org.junit.Assert.*;

public class Edit_a_computer_StepDef {
    Setup setup;
    WebDriver driver;
    PageObjectManager pageObjectManager;
    MainDatabasePage mainDatabasePage;
    EditComputerPage editComputerPage;
    AddComputerPage addComputerPage;
    HeaderPage headerPage;
;
    public Edit_a_computer_StepDef(Setup setup){
        this.setup = setup;
        driver = setup.Driver();
        pageObjectManager = new PageObjectManager(driver);
        mainDatabasePage = pageObjectManager.getMainDatabasePage();
        editComputerPage = pageObjectManager.getEditComputerPage();
        addComputerPage = pageObjectManager.getAddComputerPage();
        headerPage = pageObjectManager.getHeaderPage();
    }

    @When("I edit the computer {string} company field with {string}")
    public void iEditTheComputerCompanyFieldWith(String cName, String updatedCompany) {
        mainDatabasePage.computer_Name_Link_Click(cName);
        editComputerPage.company_Dropdown(updatedCompany);
        editComputerPage.save_This_Computer_Button_Click();
    }

    @When("I edit the computer by removing the computer name {string}")
    public void iEditTheComputerByRemovingTheComputerName(String cName) {
        mainDatabasePage.computer_Name_Link_Click(cName);
        editComputerPage.computer_Name_Input_Clear();
        editComputerPage.save_This_Computer_Button_Click();
    }

    @And("the computer is displayed with the old details {string},{string},{string} and {string}")
    public void theComputerIsDisplayedWithTheOldDetailsAnd(String cName, String iDate, String dDate, String company) {
        headerPage.header_link();
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