package setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.MainDatabasePage;

public class Setup {
    WebDriver driver;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    MainDatabasePage mainDatabasePage;

    @Before
    public void setup(){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        //mainDatabasePage = pageObjectManager.getHomePage();
        //mainDatabasePage.open_Database();
    }

    public WebDriver Driver(){
        return driver;
    }

    @After
    public void teardown(){
        webDriverManager.closeDriver();
    }
}
