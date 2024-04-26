package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class ContactDetails extends MyMethods {

    public ContactDetails() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Contact Details')]")
    private WebElement contactDetailsBtn;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[2]")
    private WebElement street1;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[3]")
    private WebElement street2;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[4]")
    private WebElement city;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[5]")
    private WebElement state;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[6]")
    private WebElement zipCode;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement country;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[7]")
    private WebElement homePhone;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[8]")
    private WebElement mobilePhone;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[9]")
    private WebElement workPhone;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[10]")
    private WebElement workEmail;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')])[11]")
    private WebElement otherEmail;

    @FindBy(xpath = "//button[contains(@type,'button') and contains(@class,'oxd-button')]")
    private WebElement addButton;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and contains(., 'Should not exceed 70 characters')]")
    private WebElement shouldNotExceed70Msg;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and contains(., 'Should not exceed 10 characters')]")
    private WebElement shouldNotExceed10Msg;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and contains(., 'Should not exceed 25 characters')]")
    private WebElement shouldNotExceed25Msg;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and contains(., 'Should not exceed 50 characters')]")
    private WebElement shouldNotExceed50Msg;

    public WebElement getContactDetailsBtn() {
        return contactDetailsBtn;
    }

    public WebElement getStreet1() {
        return street1;
    }

    public WebElement getStreet2() {
        return street2;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getHomePhone() {
        return homePhone;
    }

    public WebElement getMobilePhone() {
        return mobilePhone;
    }

    public WebElement getWorkPhone() {
        return workPhone;
    }

    public WebElement getWorkEmail() {
        return workEmail;
    }

    public WebElement getOtherEmail() {
        return otherEmail;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getShouldNotExceed70Msg() {
        return shouldNotExceed70Msg;
    }

    public WebElement getShouldNotExceed10Msg() {
        return shouldNotExceed10Msg;
    }

    public WebElement getShouldNotExceed25Msg() {
        return shouldNotExceed25Msg;
    }

    public WebElement getShouldNotExceed50Msg() {
        return shouldNotExceed50Msg;
    }
}
