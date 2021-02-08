package managers;

import org.openqa.selenium.WebDriver;
import pages.AddComputerPage;
import pages.HomePage;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private AddComputerPage addComputerPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public AddComputerPage getAddComputerPage(){
        return (addComputerPage == null) ? addComputerPage = new AddComputerPage(driver) : addComputerPage;
    }
}
