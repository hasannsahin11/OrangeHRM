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

    @FindBy(xpath = "(//input[@data-v-1f99f73c])[2]")
    private WebElement companyField;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[3]")
    private WebElement jobTitleField;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    private WebElement fromDate;

    @FindBy(xpath = "(//input[@data-v-1f99f73c and @data-v-4a95a2e0])[2]")
    private WebElement endDate;

    @FindBy(xpath = "//textarea[contains(@class, 'oxd-textarea--active')]")
    private WebElement commentField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveQualificationButton;

    @FindBy(xpath = "//div[contains(text(),'Amazon')]")
    private WebElement listedWorkExperienceCompanyName;

    @FindBy(xpath = "//div[contains(text(),'SDET')]")
    private WebElement listedWorkExperienceJobTitle;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    private WebElement editExistingWorkExpBtn;

    @FindBy(xpath = "//div[contains(text(),'Facebook')]")
    private WebElement listedWorkExperienceCompanyNameAfterUpdate;

    @FindBy(xpath = "//div[contains(text(),'QA')]")
    private WebElement listedWorkExperienceJobTitleAfterUpdate;

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

    public WebElement getCompanyField() {
        return companyField;
    }



    public WebElement getJobTitleField() {
        return jobTitleField;
    }

    public WebElement getFromDate() {
        return fromDate;
    }

    public WebElement getEndDate() {
        return endDate;
    }

    public WebElement getCommentField() {
        return commentField;
    }

    public WebElement getSaveQualificationButton() {
        return saveQualificationButton;
    }

    public WebElement getListedWorkExperienceCompanyName() {
        return listedWorkExperienceCompanyName;
    }

    public WebElement getListedWorkExperienceJobTitle() {
        return listedWorkExperienceJobTitle;
    }

    public WebElement getEditExistingWorkExpBtn() {
        return editExistingWorkExpBtn;
    }

    public WebElement getListedWorkExperienceCompanyNameAfterUpdate() {
        return listedWorkExperienceCompanyNameAfterUpdate;
    }

    public WebElement getListedWorkExperienceJobTitleAfterUpdate() {
        return listedWorkExperienceJobTitleAfterUpdate;
    }
}
