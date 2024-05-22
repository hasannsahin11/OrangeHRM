package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.EmergencyContacts;
import utils.DriverClass;

import java.util.List;
import java.util.Map;

public class _07_EmergencyContactsSteps {

    DialogContent dc = new DialogContent();
    EmergencyContacts ec = new EmergencyContacts();

    @Given("I navigate to Emergency Contacts section")
    public void i_navigate_to_emergency_contacts_section() {

        ec.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        ec.getEmergencyContactsBtn().click();
        ec.wait.until(ExpectedConditions.urlContains("viewEmergencyContacts"));

    }

    @When("I click on the Add button")
    public void i_click_on_the_add_button()  {

        ec.wait.until(ExpectedConditions.visibilityOf(ec.getAddBtn()));
        ec.getAddBtn().click();

    }

    @When("I fill out the following mandatory fields with the corresponding data:")
    public void i_fill_out_the_following_mandatory_fields_with_the_corresponding_data(List<Map<String, String>> dataTable) {

        ec.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        for (Map<String, String> row : dataTable) {
            String field = row.get("Field");
            String value = row.get("Value");

            switch (field) {

                case "Name":

                    ec.wait.until(ExpectedConditions.visibilityOf(ec.getNameField()));
                    ec.sendKeysMethod(ec.getNameField(), row.get("Value"));
                    break;

                case "Relationship":

                    ec.wait.until(ExpectedConditions.visibilityOf(ec.getRelationshipField()));
                    ec.clickMethod(ec.getRelationshipField());
                    ec.sendKeysMethod(ec.getRelationshipField(), row.get("Value"));
                    break;

                case "Mobile Number":

                    ec.wait.until(ExpectedConditions.visibilityOf(ec.getMobileNumField()));
                    ec.clickMethod(ec.getMobileNumField());
                    ec.sendKeysMethod(ec.getMobileNumField(), row.get("Value"));
                    break;

                default:

                    System.out.println("Unknown field: " + field);
                    break;
            }
        }
    }

    @Then("The new Emergency Contact should be successfully saved and displayed")
    public void the_new_emergency_contact_should_be_successfully_saved_and_displayed() {

        String addedContactName = ec.getAddedContactName().getText();
        System.out.println("addedContactName = " + addedContactName);
        Assert.assertTrue(addedContactName.equalsIgnoreCase("John Doe"));

        DriverClass.quitDriver();
    }


    @And("I fill out the fields besides {string}")
    public void iFillOutTheFieldsBesides(String arg0) {

        ec.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        ec.wait.until(ExpectedConditions.visibilityOf(ec.getRelationshipField()));
        ec.sendKeysMethod(ec.getRelationshipField(),"Cousin");

        ec.wait.until(ExpectedConditions.visibilityOf(ec.getMobileNumField()));
        ec.clickMethod(ec.getMobileNumField());
        ec.sendKeysMethod(ec.getMobileNumField(), "3215859999");

    }

    @And("I click the Save button")
    public void iClickTheSaveButton() {

        dc.waitUntilClickable(dc.getSaveBtn());
        dc.clickMethod(dc.getSaveBtn());

    }

    @Then("{string} error message should be displayed under the {string} field and contact shouldn't be saved")
    public void errorMessageShouldBeDisplayedUnderTheFieldAndContactShouldnTBeSaved(String errorMessage, String arg1) {

        ec.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        Assert.assertEquals(ec.getRequiredMessage().getText(), errorMessage);
        System.out.println("requiredMessage= " + ec.getRequiredMessage().getText());

        DriverClass.quitDriver();
    }

    @When("I click on the Edit icon of an existing Emergency Contact")
    public void iClickOnTheEditIconOfAnExistingEmergencyContact() {

        ec.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        ec.clickMethod(ec.getEditEmgContactBtn());

    }

    @And("I remove the phone number")
    public void iRemoveThePhoneNumber() {

        ec.wait.until(ExpectedConditions.visibilityOf(ec.getMobileNumField()));

        ec.clickMethod(ec.getMobileNumField());

        Actions actions = new Actions(DriverClass.getDriver());

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();

    }

    @Then("{string} error message should display under the Home Phone field and the update can't be saved")
    public void errorMessageShouldDisplayUnderTheHomePhoneFieldAndTheUpdateCanTBeSaved(String errorMsg) {

        ec.wait.until(ExpectedConditions.textToBePresentInElement(ec.getOneNumberRequiredMsg(),errorMsg));

        System.out.println("ec.getOneNumberRequiredMsg().getText() = " + ec.getOneNumberRequiredMsg().getText());
        Assert.assertEquals(ec.getOneNumberRequiredMsg().getText(), errorMsg);

        DriverClass.quitDriver();

    }
}
