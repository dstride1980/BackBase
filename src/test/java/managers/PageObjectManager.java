package managers;

import org.openqa.selenium.WebDriver;
import pages.AddComputerPage;
import pages.EditComputerPage;
import pages.HeaderPage;
import pages.MainDatabasePage;

public class PageObjectManager {
    private WebDriver driver;
    private MainDatabasePage mainDatabasePage;
    private AddComputerPage addComputerPage;
    private EditComputerPage editComputerPage;
    private HeaderPage headerPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainDatabasePage getMainDatabasePage(){
        return (mainDatabasePage == null) ? mainDatabasePage = new MainDatabasePage(driver) : mainDatabasePage;
    }

    public AddComputerPage getAddComputerPage(){
        return (addComputerPage == null) ? addComputerPage = new AddComputerPage(driver) : addComputerPage;
    }
    public EditComputerPage getEditComputerPage(){
        return (editComputerPage == null) ? editComputerPage = new EditComputerPage(driver) : editComputerPage;
    }

    public HeaderPage getHeaderPage(){
        return (headerPage == null) ? headerPage = new HeaderPage(driver) : headerPage;
    }
}
