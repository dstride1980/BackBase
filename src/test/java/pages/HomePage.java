package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    FileReaderManager fileReaderManager;

    @FindBy(css = "#add")
    private WebElement Add_Computer_Button;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open_Database() {

        driver.get(fileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void add_Computer_Button_Click(){
        Add_Computer_Button.click();
    }
}
