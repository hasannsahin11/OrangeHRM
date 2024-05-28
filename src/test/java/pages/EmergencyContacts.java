package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class EmergencyContacts extends MyMethods {

    public EmergencyContacts() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }


    @FindBy(css = "a[href='/web/index.php/pim/viewEmergencyContacts/empNumber/22']")
    private WebElement emergencyContactsBtn;

    @FindBy(xpath = "(//button[contains(@class,'oxd-button') and contains(@class,'oxd-button--medium') and contains(@class,'oxd-button--text')])[1]")
    private WebElement addBtn;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[2]")
    private WebElement nameField;

    @FindBy(xpath = "(//input[@data-v-1f99f73c])[3]")
    private WebElement relationshipField;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[4]")
    private WebElement homeNumField;

    @FindBy(xpath = "(//input[@data-v-1f99f73c])[5]")
    private WebElement mobileNumField;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[6]")
    private WebElement workNumField;

    @FindBy(xpath = "//div[contains(text(),'John Doe')]")
    private WebElement addedContactName;

    @FindBy(xpath = "//span[contains(.,'Required')]")
    private WebElement requiredMessage;

    @FindBy(xpath = "//span[contains(.,'At least one phone number is required')]")
    private WebElement oneNumberRequiredMsg;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    private WebElement editEmgContactBtn;

    @FindBy(xpath = "//span[contains(.,'Allows numbers and only + - / ( )')]")
    private WebElement allowsNumbersAndOnlySpecialCharactersErrorMsg;

    @FindBy(xpath = "//span[contains(.,'Should not exceed')]")
    private WebElement shouldntExceedErrorMsg;


    public WebElement getEmergencyContactsBtn() {
        return emergencyContactsBtn;
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getRelationshipField() {
        return relationshipField;
    }

    public WebElement getHomeNumField() {
        return homeNumField;
    }

    public WebElement getMobileNumField() {
        return mobileNumField;
    }

    public WebElement getWorkNumField() {
        return workNumField;
    }

    public WebElement getAddedContactName() {
        return addedContactName;
    }

    public WebElement getRequiredMessage() {
        return requiredMessage;
    }

    public WebElement getOneNumberRequiredMsg() {
        return oneNumberRequiredMsg;
    }

    public WebElement getEditEmgContactBtn() {
        return editEmgContactBtn;
    }

    public WebElement getAllowsNumbersAndOnlySpecialCharactersErrorMsg() {
        return allowsNumbersAndOnlySpecialCharactersErrorMsg;
    }
    public WebElement getShouldntExceedErrorMsg() {
        return shouldntExceedErrorMsg;
    }
}
