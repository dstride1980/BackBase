package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//body/section[@id='main']/form[1]/div[1]/input[1]")
    private WebElement Save_This_Computer;
    @FindBy(css = "#company")
    private WebElement Company;
    @FindBy(css = "#name")
    private WebElement Computer_Name;

    public EditComputerPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void delete_This_Computer_Button_Click(){
        executor.executeScript("arguments[0].click()", Delete_This_Computer);
    }

    public void save_This_Computer_Button_Click(){
        executor.executeScript("arguments[0].click()", Save_This_Computer);
    }

    public void company_Dropdown(String company){

        executor.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", Company, company);
    }

    public void computer_Name_Input_Clear(){

        Computer_Name.clear();
    }

    public Boolean save_Computer_Button_Displayed(){

        var displayed = Save_This_Computer.isDisplayed();
        return displayed;
    }
}