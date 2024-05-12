package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class JobDetails extends MyMethods {
    public JobDetails(){
        PageFactory.initElements(DriverClass.getDriver(),this);
    }

    @FindBy(css = "a[href='/web/index.php/pim/viewJobDetails/empNumber/22']")
    private WebElement jobBtn;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active') and contains(@class,'oxd-select-text--disabled')])[1]")
    private WebElement jobTitleField;

    public WebElement getJobBtn() {
        return jobBtn;
    }

    public WebElement getJobTitleField() {
        return jobTitleField;
    }
}
