package pages;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDatabasePage {
    WebDriver driver;
    FileReaderManager fileReaderManager;

    @FindBy(css = "#add")
    private WebElement Add_Computer_Button;
    @FindBy(xpath = "//tbody/tr")
    private WebElement Table_Row;

    public MainDatabasePage(WebDriver driver){
        this.driver = driver;
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
        }
        return values;
    }

    public Date format_Date(String date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date fullDate = null;
        try {
            fullDate = format.parse(date);
            //format = new SimpleDateFormat("dd MMM yyyy");
            //value = format.format(date);
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
}
