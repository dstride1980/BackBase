package setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.EditComputerPage;
import pages.HeaderPage;
import pages.MainDatabasePage;

public class Setup {
    WebDriver driver;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    HeaderPage headerPage;
    EditComputerPage editComputerPage;
    MainDatabasePage mainDatabasePage;

    @Before
    public void setup(){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    public WebDriver Driver(){
        return driver;
    }

    @After
    public void teardown(){
        mainDatabasePage = pageObjectManager.getMainDatabasePage();
        editComputerPage = pageObjectManager.getEditComputerPage();
        headerPage = pageObjectManager.getHeaderPage();
        headerPage.header_link();
        if(mainDatabasePage.search_Table("AAAAA") != null){
            mainDatabasePage.computer_Name_Link_Click("AAAAA");
            editComputerPage.delete_This_Computer_Button_Click();
        }
        webDriverManager.closeDriver();
    }
}
