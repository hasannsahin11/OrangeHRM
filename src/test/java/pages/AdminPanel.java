package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class AdminPanel extends MyMethods {

    public AdminPanel() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    private WebElement userName;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminBtn;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement userRoleSelect;

    @FindBy(xpath ="(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusSelect;

    @FindBy (css = "input[data-v-75e744cd][placeholder=\"Type for hints...\"]")
    private WebElement employeeName;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')])[2]")
    private WebElement essUserName;

    @FindBy (xpath = "(//input[@type='password'])[1]")
    private WebElement essPassword;

    @FindBy (xpath = "(//input[@type='password'])[2]")
    private WebElement essConfPassword;



    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getAdminBtn() {
        return adminBtn;
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public WebElement getUserRoleSelect() {
        return userRoleSelect;
    }

    public WebElement getStatusSelect() {
        return statusSelect;
    }

    public WebElement getEmployeeName() {
        return employeeName;
    }

    public WebElement getEssUserName() {
        return essUserName;
    }

    public WebElement getEssPassword() {
        return essPassword;
    }

    public WebElement getEssConfPassword() {
        return essConfPassword;
    }

}
