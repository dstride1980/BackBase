package managers;

import org.openqa.selenium.WebDriver;
import pages.AddComputerPage;
import pages.MainDatabasePage;

public class PageObjectManager {
    private WebDriver driver;
    private MainDatabasePage mainDatabasePage;
    private AddComputerPage addComputerPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainDatabasePage getHomePage(){
        return (mainDatabasePage == null) ? mainDatabasePage = new MainDatabasePage(driver) : mainDatabasePage;
    }

    public AddComputerPage getAddComputerPage(){
        return (addComputerPage == null) ? addComputerPage = new AddComputerPage(driver) : addComputerPage;
    }
}
