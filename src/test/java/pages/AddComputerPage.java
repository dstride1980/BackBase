package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

        executor.executeScript("arguments[0].value='"+cName+"'", Computer_Name);
    }

    public void introduced_Date_Input(String iDate){

        executor.executeScript("arguments[0].value='"+iDate+"'", Introduced_Date);
    }

    public void discontinued_Date_Input(String dDate){

        executor.executeScript("arguments[0].value='"+dDate+"'", Discontinued_Date);
    }

    public void company_Dropdown(String company){

        executor.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", Company, company);
    }

    public void create_Computer_Button_Click(){

        executor.executeScript("arguments[0].click()", Create_This_Computer);
    }
}
