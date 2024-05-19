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

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement addBtn;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[2]")
    private WebElement nameField;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[3]")
    private WebElement relationshipField;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input') and contains(@class,'oxd-input--active')])[5]")
    private WebElement mobileNumField;

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

    public WebElement getMobileNumField() {
        return mobileNumField;
    }
}
