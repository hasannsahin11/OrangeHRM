package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ContactDetails;

public class _06_ContactDetailsSteps {

    ContactDetails cd = new ContactDetails();

    @When("I navigate to the Contact Details page")
    public void i_navigate_to_the_contact_details_page() {

        cd.getContactDetailsBtn().click();
    }

    @Then("{string} should be displayed in the Work Email field")
    public void should_be_displayed_in_the_work_email_field(String workEmail) {

        cd.wait.until(ExpectedConditions.urlContains("contactDetails"));
        cd.wait.until(ExpectedConditions.attributeToBe(cd.getWorkEmail(),"value",workEmail));
        System.out.println(cd.getWorkEmail().getAttribute("value"));
        Assert.assertEquals(cd.getWorkEmail().getAttribute("value"), workEmail);
    }

}
