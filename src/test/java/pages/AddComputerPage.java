package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddComputerPage {
    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(css = "#name")
    private WebElement Computer_Name;
    @FindBy(css = "#introduced")
    private WebElement Introduced_Date;
    @FindBy(css = "#discontinued")
    private WebElement Discontinued_Date;
    @FindBy(css = "#company")
    private WebElement Company;
    @FindBy(xpath = "//body/section[@id='main']/form[1]/div[1]/input[1]")
    private WebElement Create_This_Computer;

    public AddComputerPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void computer_Name_Input(String cName){
        Computer_Name.sendKeys(cName);
    }

    public void introduced_Date_Input(String iDate){
        Introduced_Date.sendKeys(iDate);
    }

    public void discontinued_Date_Input(String dDate){
        Discontinued_Date.sendKeys(dDate);
    }

    public void company_Dropdown(String company){
         Company.sendKeys(company);
    }

    public void create_Computer_Button_Click(){
        Create_This_Computer.click();
    }
}
