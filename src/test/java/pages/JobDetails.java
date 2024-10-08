package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class JobDetails extends MyMethods {
    public JobDetails() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(css = "a[href='/web/index.php/pim/viewJobDetails/empNumber/22']")
    private WebElement jobBtn;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active') and contains(@class,'oxd-select-text--disabled')])[1]")
    private WebElement jobTitleField;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    private WebElement joinedDate;

    @FindBy(css = ".oxd-icon.bi-calendar.oxd-date-input-icon.--disabled")
    private WebElement joinedDateCalender;

    @FindBy(css = ".input-container.--disabled")
    private WebElement jobSpecificationTitle;

    @FindBy(css = ".oxd-text.oxd-text--p.input-container-filename")
    private WebElement jobSpecificationValue;

    @FindBy(css = ".oxd-switch-input.oxd-switch-input--active.--label-right")
    private WebElement contractDetailsSwitchBtn;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    private WebElement contractStartDate;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[3]")
    private WebElement contractEndDate;

    @FindBy(css = ".oxd-file-button.--disabled")
    private WebElement contractDetails;

    public WebElement getJobBtn() {
        return jobBtn;
    }

    public WebElement getJobTitleField() {
        return jobTitleField;
    }

    public WebElement getJoinedDate() {
        return joinedDate;
    }

    public WebElement getJoinedDateCalender() {
        return joinedDateCalender;
    }

    public WebElement getJobSpecificationTitle() {
        return jobSpecificationTitle;
    }

    public WebElement getJobSpecificationValue() {
        return jobSpecificationValue;
    }

    public WebElement getContractDetailsSwitchBtn() {
        return contractDetailsSwitchBtn;
    }

    public WebElement getContractStartDate() {
        return contractStartDate;
    }

    public WebElement getContractEndDate() {
        return contractEndDate;
    }

    public WebElement getContractDetails() {
        return contractDetails;
    }
}
