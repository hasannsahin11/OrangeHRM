package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ContactDetails;
import pages.DialogContent;
import utils.DriverClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class MI_03_ContactDetailsSteps {

    ContactDetails cd = new ContactDetails();
    DialogContent dc = new DialogContent();

    @When("I navigate to the Contact Details page")
    public void i_navigate_to_the_contact_details_page() {

        cd.getContactDetailsBtn().click();
    }

    @Then("{string} should be displayed in the Work Email field")
    public void should_be_displayed_in_the_work_email_field(String workEmail) {

        cd.wait.until(ExpectedConditions.urlContains("contactDetails"));
        cd.wait.until(ExpectedConditions.attributeToBe(cd.getWorkEmail(), "value", workEmail));
        System.out.println("Displayed email address when navigated to the Contact Details page: " + cd.getWorkEmail().getAttribute("value"));
        Assert.assertEquals(cd.getWorkEmail().getAttribute("value"), workEmail);

        DriverClass.quitDriver();

    }

    @And("I enter a valid street address, city, state, and postal code into the respective fields")
    public void i_enter_a_valid_street_address_city_state_and_postal_code_into_the_respective_fields() throws InterruptedException {

        cd.wait.until(ExpectedConditions.urlContains("contactDetails"));
        cd.wait.until(ExpectedConditions.attributeToBe(cd.getWorkEmail(), "value", "sania1@osohrm.com"));

        cd.waitUntilClickable(cd.getStreet1());
        cd.sendKeysMethod(cd.getStreet1(), "221B Baker St");

        cd.waitUntilClickable(cd.getStreet2());
        cd.clickMethod(cd.getStreet2());
        cd.sendKeysMethod(cd.getStreet2(), "Coach House #2");

        cd.waitUntilClickable(cd.getCity());
        cd.clickMethod(cd.getCity());
        cd.sendKeysMethod(cd.getCity(), "Springfield");

        cd.waitUntilClickable(cd.getState());
        cd.clickMethod(cd.getState());
        cd.sendKeysMethod(cd.getState(), "Illinois");

        cd.waitUntilClickable(cd.getZipCode());
        cd.clickMethod(cd.getZipCode());
        cd.sendKeysMethod(cd.getZipCode(), "62629");


        try {
            Robot robot = new Robot();
            robot.delay(1500);


            cd.clickMethod(cd.getCountry());


            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);


            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @And("I enter a valid home, mobile, and work phone numbers into the respective fields")
    public void i_enter_a_valid_home_mobile_and_work_phone_numbers_into_the_respective_fields() {

        cd.wait.until(ExpectedConditions.attributeToBe(cd.getWorkEmail(), "value", "sania1@osohrm.com"));

        cd.waitUntilClickable(cd.getHomePhone());
        cd.sendKeysMethod(cd.getHomePhone(), "+12169180");


        cd.waitUntilClickable(cd.getMobilePhone());
        cd.clickMethod(cd.getMobilePhone());
        cd.sendKeysMethod(cd.getMobilePhone(), "+15586669931");

        cd.waitUntilClickable(cd.getWorkPhone());
        cd.clickMethod(cd.getWorkPhone());
        cd.sendKeysMethod(cd.getWorkPhone(), "+13218524655");

    }

    @And("I enter a valid alternative email address into the respective field")
    public void i_enter_a_valid_alternative_email_address_into_the_respective_field() {

        String otherEmail = "sshaheen11@qa.com";

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(otherEmail);
        clipboard.setContents(stringSelection, null);

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(1000);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the contact information should be saved and displayed successfully")
    public void the_contact_information_should_be_saved_and_displayed_successfully() {

        Assert.assertTrue(dc.getSuccessMessage().getText().equalsIgnoreCase("Successfully Updated"));

        cd.wait.until(ExpectedConditions.attributeToBe(cd.getStreet1(), "value", "221B Baker St"));
        Assert.assertEquals(cd.getStreet1().getAttribute("value"), "221B Baker St");

//        System.out.println("Here is the updated Street Name: " + cd.getStreet1().getAttribute("value"));

        DriverClass.quitDriver();

    }

    @Then("the updated contact information should be displayed accurately")
    public void the_updated_contact_information_should_be_displayed_accurately() {

        cd.wait.until(ExpectedConditions.attributeToBe(cd.getWorkEmail(), "value", "sania1@osohrm.com"));

        Assert.assertEquals(cd.getStreet1().getAttribute("value"), "221B Baker St");
        System.out.println("cd.getStreet1().getAttribute(\"value\") = " + cd.getStreet1().getAttribute("value"));

        Assert.assertEquals(cd.getStreet2().getAttribute("value"), "Coach House #2");
        System.out.println("cd.getStreet2().getAttribute(\"value\") = " + cd.getStreet2().getAttribute("value"));

        Assert.assertEquals(cd.getCity().getAttribute("value"), "Springfield");
        System.out.println("cd.getCity().getAttribute(\"value\") = " + cd.getCity().getAttribute("value"));

        Assert.assertEquals(cd.getState().getAttribute("value"), "Illinois");
        System.out.println("cd.getState().getAttribute(\"value\") = " + cd.getState().getAttribute("value"));

        Assert.assertEquals(cd.getZipCode().getAttribute("value"), "62629");
        System.out.println("cd.getZipCode().getAttribute(\"value\") = " + cd.getZipCode().getAttribute("value"));

        Assert.assertEquals(cd.getMobilePhone().getAttribute("value"), "+15586669931");
        System.out.println("cd.getMobilePhone().getAttribute(\"value\") = " + cd.getMobilePhone().getAttribute("value"));

        Assert.assertEquals(cd.getOtherEmail().getAttribute("value"), "sshaheen11@qa.com");
        System.out.println("cd.getOtherEmail().getAttribute(\"value\") = " + cd.getOtherEmail().getAttribute("value"));

        DriverClass.quitDriver();
    }

    @And("I remove all the contact details")
    public void i_remove_all_the_contact_details() throws InterruptedException {

        Actions actions = new Actions(DriverClass.getDriver());

        cd.wait.until(ExpectedConditions.attributeToBe(cd.getStreet1(), "value", "221B Baker St"));

        cd.getStreet1().click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Address 1 details has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Address 2 details has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("City name has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("State name has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("ZipCode has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        JavascriptExecutor js = (JavascriptExecutor) DriverClass.getDriver();
        js.executeScript("var dropdown = document.querySelector('.oxd-select-text-input'); dropdown.innerText = '-- Select --';");


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Country name has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Home Phone number has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Mobile Phone number has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Work Phone number has been removed.");
        actions.sendKeys(Keys.TAB).perform();


        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Work Email Address has been removed.");
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Other Email Address has been removed.");
    }

    @Then("the changes should be saved and there is no contact information displayed")
    public void the_changes_should_be_saved_and_there_is_no_contact_information_displayed() {

        Assert.assertEquals(cd.getStreet1().getAttribute("value"), "");
        System.out.println("This is the value in Street 1 field: " + "\"" + cd.getStreet1().getAttribute("value") + "\"");
        DriverClass.quitDriver();
    }


    @And("Enter an address with more than {string} characters.")
    public void enterAnAddressWithMoreThanCharacters(String arg0) {
        cd.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));


        cd.sendKeysMethod(cd.getStreet1(), "221B Baker St Coach House #2 Springfield Illinois 62629 United States of America");
    }

    @And("Enter a zipcode with more than {string} characters.")
    public void enterAZipcodeWithMoreThanCharacters(String arg0) {

        cd.waitUntilClickable(cd.getZipCode());
        cd.clickMethod(cd.getZipCode());
        cd.sendKeysMethod(cd.getZipCode(), "62629626291");

    }

    @And("Enter a home phone number with more than {string} characters.")
    public void enterAHomePhoneNumberWithMoreThanCharacters(String arg0) {

        cd.waitUntilClickable(cd.getHomePhone());
        cd.clickMethod(cd.getHomePhone());
        cd.sendKeysMethod(cd.getHomePhone(), "+1234567891011121314151617");


    }

    @And("Enter an email address with more than {string} characters.")
    public void enterAnEmailAddressWithMoreThanCharacters(String arg0) {

        String exceededEmail = "sshaheen11qa.comsshaheen11qa.comsshaheen1111@qa.com";

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(exceededEmail);
        clipboard.setContents(stringSelection, null);

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(1000);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The system should prevent the user from entering more than required amounts and display a red error message under each field")
    public void the_system_should_prevent_the_user_from_entering_more_than_required_amounts_and_display_a_red_error_message_under_each_field() {

        dc.clickMethod(dc.getSaveBtn());

        Assert.assertTrue(cd.getShouldNotExceed70Msg().getText().contains("Should not exceed 70 characters"));
        System.out.println("Address 1 Field :" + cd.getShouldNotExceed70Msg().getText());

        Assert.assertTrue(cd.getShouldNotExceed10Msg().getText().contains("Should not exceed 10 characters"));
        System.out.println("Zipcode Field :" + cd.getShouldNotExceed10Msg().getText());

        Assert.assertTrue(cd.getShouldNotExceed25Msg().getText().contains("Should not exceed 25 characters"));
        System.out.println("Home Phone Number Field :" + cd.getShouldNotExceed25Msg().getText());

        Assert.assertTrue(cd.getShouldNotExceed50Msg().getText().contains("Should not exceed 50 characters"));
        System.out.println("Other Email Field :" + cd.getShouldNotExceed50Msg().getText());

        DriverClass.quitDriver();
    }

    @And("I enter a new Work Email address")
    public void i_enter_a_new_work_email_address() {
        cd.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        cd.getWorkEmail().sendKeys("sania1@osohrm.com");

        dc.getSaveBtn().click();

        cd.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

    }

    @Then("The new email address successfully saved and displayed")
    public void the_new_email_address_successfully_saved_and_displayed() {

        System.out.println(cd.getWorkEmail().getAttribute("value"));
        Assert.assertEquals(cd.getWorkEmail().getAttribute("value"), "sania1@osohrm.com");

        DriverClass.quitDriver();

    }

    @And("I enter same Work Email address into the Other Email field")
    public void i_enter_same_work_email_address_into_the_other_email_field() {

        cd.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        cd.getOtherEmail().sendKeys("sania1@osohrm.com");

    }
    @Then("{string} message displays in red under the corresponding field")
    public void message_displays_in_red_under_the_corresponding_field(String string) {

        System.out.println("Displayed message after adding the same email address into the Other Email address: " + "\"" + cd.getAlreadyExistsMsg().getText()+ "\"");
        Assert.assertEquals(cd.getAlreadyExistsMsg().getText(),string);

    }

    @Then("{string} message displays under existing Work Email address' field once I click save")
    public void message_displays_under_existing_work_email_address_field_once_i_click_save(String string) {

        dc.getSaveBtn().click();

        System.out.println("Displayed message after trying to save the same email address under the existing email address' field: " + "\"" + cd.getEmailsCantBeSameMsg().getText()+ "\"");
        Assert.assertEquals(cd.getEmailsCantBeSameMsg().getText(),string);

    }

}
