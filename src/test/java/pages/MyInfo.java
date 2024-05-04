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

    @FindBy(name = "lastName")
    private WebElement lastName;

//    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
//    private WebElement successfullyUpdatedMsg;

    @FindBy(xpath = "//span[contains(.,'Required')]")
    private WebElement requiredMsg;

    @FindBy(xpath = "(//img[@alt='profile picture'])[2]")
    private WebElement profilePic;

    @FindBy(css = "button.oxd-icon-button.oxd-icon-button--solid-main.employee-image-action")
    private WebElement uploadBtn;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[1]")
    private WebElement nationality;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[2]")
    private WebElement maritalStatus;

    @FindBy(css = ".oxd-radio-input.oxd-radio-input--active.--label-right.oxd-radio-input")
    private WebElement maleRadioBtn;

    @FindBy(css = "input[type='radio']")
    private WebElement maleOuterRadioBtn;


    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
    private WebElement bloodType;

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

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getRequiredMsg() {
        return requiredMsg;
    }

    public WebElement getProfilePic() {
        return profilePic;
    }

    public WebElement getUploadBtn() {
        return uploadBtn;
    }

    public WebElement getNationality() {
        return nationality;
    }

    public WebElement getMaritalStatus() {
        return maritalStatus;
    }

    public WebElement getMaleRadioBtn() {
        return maleRadioBtn;
    }
    public WebElement getMaleOuterRadioBtn() {
        return maleOuterRadioBtn;
    }

    public WebElement getBloodType() {
        return bloodType;
    }
}
