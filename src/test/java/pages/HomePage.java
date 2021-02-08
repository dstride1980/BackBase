package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    FileReaderManager fileReaderManager;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open_Database() {
        driver.get(fileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
