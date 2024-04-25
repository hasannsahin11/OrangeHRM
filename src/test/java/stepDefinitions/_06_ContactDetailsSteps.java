package stepDefinitions;

import io.cucumber.java.en.*;
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

public class _06_ContactDetailsSteps {

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

    @Then("the contact information should be saved successfully")
    public void the_contact_information_should_be_saved_successfully() {

        Assert.assertTrue(dc.getSuccessMessage().getText().equalsIgnoreCase("Successfully Updated"));

        cd.wait.until(ExpectedConditions.attributeToBe(cd.getStreet1(),"value","221B Baker St"));
        Assert.assertEquals(cd.getStreet1().getAttribute("value"),"221B Baker St");

        System.out.println(cd.getStreet1().getAttribute("value"));

        DriverClass.quitDriver();

    }

}
