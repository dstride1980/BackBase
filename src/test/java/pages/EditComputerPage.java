package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputerPage {
    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(xpath = "//body/section[@id='main']/form[2]/input[1]")
    private WebElement Delete_This_Computer;

    public EditComputerPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void delete_This_Computer_Button_Click(){
        executor.executeScript("arguments[0].click()", Delete_This_Computer);
    }
}