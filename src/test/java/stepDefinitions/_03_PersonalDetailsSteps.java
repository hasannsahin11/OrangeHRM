package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ContactDetails;
import pages.DialogContent;
import pages.MyInfo;
import utils.DriverClass;

import java.security.Key;
import java.util.List;

public class _03_PersonalDetailsSteps {

    MyInfo mi = new MyInfo();
    DialogContent dc = new DialogContent();


    @When("I navigate to the My Info page")
    public void i_navigate_to_my_ifo_page() {
        mi.clickMethod(mi.getMyInfoBtn());
    }

    @Then("the following fields should be disabled in the Personal Details section:")
    public void the_following_fields_should_be_disabled_in_the_personal_details_section(DataTable dataTable) {
        List<String> disabledFields = dataTable.asList(String.class);

        for (String fields : disabledFields) {

            switch (fields) {
                case "Employee ID":
                    mi.wait.until(ExpectedConditions.visibilityOf(mi.getEmployeeId()));
                    Assert.assertFalse(mi.getEmployeeId().isEnabled());
                    System.out.println("Employee ID field is not disabled as expected.");

                    String colorValue = mi.getEmployeeId().getCssValue("color");
                    System.out.println("Color of the field :" + colorValue);
                    Assert.assertEquals(colorValue, "rgba(100, 114, 140, 1)",
                            "Color of the field is not as expected: #64728c");

                    break;

                case "Driver License No":
                    mi.wait.until(ExpectedConditions.visibilityOf(mi.getDriversLicenseNo()));
                    Assert.assertFalse(mi.getDriversLicenseNo().isEnabled());
                    System.out.println("Driver's License Number field is not disabled as expected.");

                    colorValue = mi.getDriversLicenseNo().getCssValue("color");
                    System.out.println("Color of the field :" + colorValue);
                    Assert.assertEquals(colorValue, "rgba(100, 114, 140, 1)",
                            "Color of the field is not as expected: #64728c");

                    break;

                case "Date of Birth":
                    mi.wait.until(ExpectedConditions.visibilityOf(mi.getDateOfBirth()));
                    Assert.assertFalse(mi.getDateOfBirth().isEnabled());
                    System.out.println("Date of Birth field is not disabled as expected.");

                    colorValue = mi.getDateOfBirth().getCssValue("color");
                    System.out.println("Color of the field :" + colorValue);
                    Assert.assertEquals(colorValue, "rgba(100, 114, 140, 1)",
                            "Color of the field is not as expected: #64728c");

                    break;
            }

        }
        DriverClass.quitDriver();
    }

    Actions actions = new Actions(DriverClass.getDriver());

    @When("I change the First Name field to {string}")
    public void i_change_the_field_to(String firstName) {

        mi.wait.until(ExpectedConditions.elementToBeClickable(mi.getFirstName()));
        mi.getFirstName().click();
        while (!mi.getFirstName().getAttribute("value").isEmpty()) {
            mi.getFirstName().sendKeys(Keys.BACK_SPACE);
        }
        mi.sendKeysMethod(mi.getFirstName(), firstName);
    }

    @Then("the updated first name should be displayed")
    public void the_updated_first_name_should_be_displayed() {
        mi.waitUntilVisible(mi.getFirstName());
        String value = mi.getFirstName().getAttribute("value");
        System.out.println("Updated name :" + value);
        Assert.assertTrue(value.equalsIgnoreCase("Sonia"));

        actions.scrollToElement(mi.getFirstName()).perform();

        DriverClass.quitDriver();
    }

    @When("I delete the value from Last Name field")
    public void i_delete_the_value_from_last_name_field() {

        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
        mi.getLastName().click();
        while (!mi.getLastName().getAttribute("value").isEmpty()) {
            mi.getLastName().sendKeys(Keys.BACK_SPACE);
        }
    }

    @Then("{string} message in red should display under the Last Name field and the change shouldn't be saved")
    public void message_in_red_should_display_under_the_last_name_field_and_the_change_shouldn_t_be_saved(String requiredMsg) {

        System.out.println("Displayed Error Message When Deleted Last Name: " + mi.getRequiredMsg().getText());
        Assert.assertEquals(mi.getRequiredMsg().getText(), requiredMsg);

        dc.clickMethod(dc.getSaveBtn());
        System.out.println("Clicked the " + dc.getSaveBtn().getText() + " button.");

        mi.clickMethod(mi.getMyInfoBtn());

        mi.wait.until(ExpectedConditions.attributeToBe(mi.getLastName(), "value", "Shaheen"));
        System.out.println("Value in the Last Name field after refreshing the page: " + "\"" + mi.getLastName().getAttribute("value") + "\"");

        DriverClass.quitDriver();

    }

    @When("I delete the value from First Name field")
    public void iDeleteTheValueFromFirstNameField() {

        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        mi.getFirstName().click();
        while (!mi.getFirstName().getAttribute("value").isEmpty()) {
            mi.getFirstName().sendKeys(Keys.BACK_SPACE);
        }
    }

    @Then("{string} message in red should display under the First Name field and the change shouldn't be saved")
    public void messageInRedShouldDisplayUnderTheFirstNameFieldAndTheChangeShouldnTBeSaved(String requiredMsg) {

        System.out.println("Displayed Error Message When Deleted First Name: " + mi.getRequiredMsg().getText());
        Assert.assertEquals(mi.getRequiredMsg().getText(), requiredMsg);

        dc.clickMethod(dc.getSaveBtn());
        System.out.println("Clicked the " + dc.getSaveBtn().getText() + " button.");

        mi.clickMethod(mi.getMyInfoBtn());

        mi.wait.until(ExpectedConditions.attributeToBe(mi.getFirstName(), "value", "Sania"));
        System.out.println("Value in the First Name field after refreshing the page: " + "\"" + mi.getFirstName().getAttribute("value") + "\"");

        DriverClass.quitDriver();

    }


    @When("I update the Nationality to French")
    public void iUpdateTheNationalityToFrench() {

        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        System.out.println("Nationality before the update: " + "\"" + mi.getNationality().getText() + "\"");
        mi.getNationality().click();

        actions.sendKeys("f").sendKeys("f").sendKeys("f").sendKeys("f").sendKeys(Keys.ENTER).build().perform();

    }

    @Then("The updated Nationality should be successfully saved and displayed")
    public void theUpdatedNationalityShouldBeSuccessfullySavedAndDisplayed() {

        mi.wait.until(ExpectedConditions.textToBe(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[1]"), "French"));

        Assert.assertEquals(mi.getNationality().getText(), "French");
        System.out.println("Updated Nationality: " + "\"" + mi.getNationality().getText() + "\"");

        DriverClass.quitDriver();

    }

    @When("I update the Marital Status to Single")
    public void iUpdateTheMaritalStatusToSingle() {
        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        System.out.println("Marital Status before the update: " + "\"" + mi.getMaritalStatus().getText() + "\"");
        mi.getMaritalStatus().click();

        actions.sendKeys("o").sendKeys(Keys.ENTER).build().perform();
    }

    @Then("The updated Marital Status should be successfully saved and displayed")
    public void theUpdatedMaritalStatusShouldBeSuccessfullySavedAndDisplayed() {
        mi.wait.until(ExpectedConditions.textToBe(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[2]"), "Other"));

        Assert.assertEquals(mi.getMaritalStatus().getText(), "Other");
        System.out.println("Updated Marital Status: " + "\"" + mi.getMaritalStatus().getText() + "\"");

        DriverClass.quitDriver();
    }

    @When("I click on Male radio button")
    public void iClickOnMaleRadioButton() {
        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        mi.waitUntilClickable(mi.getMaleRadioBtn());
        mi.getMaleRadioBtn().click();
    }

    @Then("The Gender should be successfully saved and displayed")
    public void theGenderShouldBeSuccessfullySavedAndDisplayed() {

        mi.wait.until(ExpectedConditions.elementToBeSelected(mi.getMaleOuterRadioBtn()));

        Assert.assertTrue(mi.getMaleOuterRadioBtn().isSelected(),"It is not selected.");

        System.out.println("Gender has been modified as \"Male\"");

        DriverClass.quitDriver();
    }

    @When("I select AB+ from the blood type dropdown")
    public void iSelectABFromTheBloodTypeDropdown() {

        mi.waitUntilClickable(mi.getBloodType());
        mi.getBloodType().click();

        actions.sendKeys("a").sendKeys("a").sendKeys("a").sendKeys(Keys.ENTER).build().perform();


    }

    @Then("the selected blood type should be successfully saved and displayed")
    public void theSelectedBloodTypeShouldBeSuccessfullySavedAndDisplayed() {

        mi.wait.until(ExpectedConditions.textToBe(By.xpath("(//div[@class='oxd-select-text-input'])[3]"),"AB+"));
        Assert.assertEquals(mi.getBloodType().getText(),"AB+");

        System.out.println("Updated Blood Type: " + "\"" + mi.getBloodType().getText() + "\"");

        DriverClass.quitDriver();

    }


    @When("I enter a First Name with more than forty characters")
    public void iEnterAFirstNameWithMoreThanFortyCharacters() {
    }

    @And("I enter a Middle Name with more than forty characters")
    public void iEnterAMiddleNameWithMoreThanFortyCharacters() {
    }

    @And("I enter a Last Name with more than forty characters")
    public void iEnterALastNameWithMoreThanFortyCharacters() {
    }

    @And("I enter an Other Id with more than forty characters")
    public void iEnterAnOtherIdWithMoreThanFortyCharacters() {
    }

    @And("I enter a valid value in the Test_Field with more than two hundred and fifty characters")
    public void iEnterAValidValueInTheTest_FieldWithMoreThanTwoHundredAndFiftyCharacters() {
    }

    @Then("The system should prevent me from entering more than required amounts and display a red error message under each field")
    public void theSystemShouldPreventMeFromEnteringMoreThanRequiredAmountsAndDisplayARedErrorMessageUnderEachField() {
    }
}
