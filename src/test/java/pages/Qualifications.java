package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class Qualifications extends MyMethods {

    public Qualifications() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(.,'Qualifications')]")
    private WebElement qualificationsBtn;

    @FindBy(xpath = "//h6[contains(.,'Work Experience')]")
    private WebElement workExperience;

    @FindBy(xpath = "//h6[contains(.,'Education')]")
    private WebElement education;

    @FindBy(xpath = "//h6[contains(.,'Skills')]")
    private WebElement skills;

    @FindBy(xpath = "//h6[contains(.,'Languages')]")
    private WebElement languages;

    @FindBy(xpath = "//h6[contains(.,'License')]")
    private WebElement license;

    @FindBy(xpath = "//h6[contains(.,'Attachments')]")
    private WebElement attachments;

    @FindBy (xpath = "(//button[@type='button' and contains(@class, 'oxd-button--text')])[1]")
    private WebElement workExpAddBtn;

    public WebElement getQualificationsBtn() {
        return qualificationsBtn;
    }

    public WebElement getWorkExperience() {
        return workExperience;
    }

    public WebElement getEducation() {
        return education;
    }

    public WebElement getSkills() {
        return skills;
    }

    public WebElement getLanguages() {
        return languages;
    }

    public WebElement getLicense() {
        return license;
    }

    public WebElement getAttachments() {
        return attachments;
    }

    public WebElement getWorkExpAddBtn() {
        return workExpAddBtn;
    }
}
