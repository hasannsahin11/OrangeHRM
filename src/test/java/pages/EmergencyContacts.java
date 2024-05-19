package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;
import utils.MyMethods;

public class EmergencyContacts extends MyMethods {

    public EmergencyContacts(){
        PageFactory.initElements(DriverClass.getDriver(),this);
    }


    @FindBy(css = "a[href='/web/index.php/pim/viewEmergencyContacts/empNumber/22']")
    private WebElement emergencyContactsBtn;






}
