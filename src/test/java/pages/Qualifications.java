package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class Qualifications extends MyMethods {

    public Qualifications(){
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

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

}
