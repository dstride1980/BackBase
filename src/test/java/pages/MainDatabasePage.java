package pages;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDatabasePage {
    WebDriver driver;
    JavascriptExecutor executor;
    FileReaderManager fileReaderManager;

    @FindBy(css = "#add")
    private WebElement Add_Computer_Button;

    public MainDatabasePage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void open_Database() {

        driver.get(fileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void add_Computer_Button_Click(){

        Add_Computer_Button.click();
    }

    public String search_Table(String value){
        String values = null;
        if (value.contains("-")){
            var date = format_Date(value, "yyyy-MM-dd");
            value = format_Date(date, "dd MMM yyyy");
        }
        var tableRowCount = driver.findElements(By.xpath("//tbody/tr"));
        for(WebElement element:tableRowCount){
            values = element.getText();
            if(values.contains(value)){
                break;
            }
            else{
                values = null;
            }
        }
        return values;
    }

    public Date format_Date(String date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date fullDate = null;
        try {
            fullDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fullDate;
    }

    public String format_Date(Date date, String pattern){
        String fullDate = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        fullDate = format.format(date);
        return fullDate;
    }

    public void computer_Name_Link_Click(String cName){
        executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[contains(text(),'"+cName+"')]")));
    }
}