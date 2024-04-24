package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class DialogContent extends MyMethods {

    public DialogContent() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement saveBtn;

    @FindBy (xpath = "//p[@data-v-7b563373 and @data-v-35c8fe09 and contains(@class, 'oxd-text') and contains(@class, 'oxd-text--toast-message') and contains(@class, 'oxd-toast-content-text')]")
    private WebElement successMessage;

    @FindBy(css = ".oxd-input-field-error-message")
    private WebElement imageErrorMsg;


    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getImageErrorMsg() {
        return imageErrorMsg;
    }
}
