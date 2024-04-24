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

   @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')][@data-v-1f99f73c])[10]")
    private WebElement workEmail;

    public WebElement getContactDetailsBtn() {
        return contactDetailsBtn;
    }

    public WebElement getWorkEmail() {
        return workEmail;
    }
}
