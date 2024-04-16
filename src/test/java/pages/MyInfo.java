package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class MyInfo extends MyMethods {
    public MyInfo() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
    private WebElement myInfoBtn;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and @disabled])[1]")
    private WebElement employeeId;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and @disabled])[2]")
    private WebElement driversLicenseNo;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and @disabled])[3]")
    private WebElement dateOfBirth;

    @FindBy(name = "firstName")
    private WebElement firstName;

//    @FindBy(xpath = "(//button[@type='submit'])[2]")
//    private WebElement saveBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement successfullyUpdatedMsg;

    public WebElement getMyInfoBtn() {
        return myInfoBtn;
    }

    public WebElement getEmployeeId() {
        return employeeId;
    }

    public WebElement getDriversLicenseNo() {
        return driversLicenseNo;
    }

    public WebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public WebElement getFirstName() {
        return firstName;
    }

//    public WebElement getSaveBtn() {
//        return saveBtn;
//    }

    public WebElement getSuccessfullyUpdatedMsg() {
        return successfullyUpdatedMsg;
    }
}
