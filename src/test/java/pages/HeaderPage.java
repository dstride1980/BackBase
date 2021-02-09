package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(xpath = "//a[contains(text(),'Play sample application — Computer database')]")
    private WebElement Header_Link;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void header_link(){
        executor.executeScript("arguments[0].click()", Header_Link);
    }
}