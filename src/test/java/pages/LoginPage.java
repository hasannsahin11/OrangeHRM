package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class LoginPage extends MyMethods {
    public LoginPage() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    private WebElement userName;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(css = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    private WebElement dashboard;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    private WebElement invalidCredentialsMsg;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getDashboard() {
        return dashboard;
    }

    public WebElement getInvalidCredentialsMsg() {
        return invalidCredentialsMsg;
    }
}
