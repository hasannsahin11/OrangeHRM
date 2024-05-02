package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.MyInfo;
import utils.DriverClass;

import java.security.Key;
import java.util.List;

public class _03_PersonalDetailsSteps {

    MyInfo mi = new MyInfo();

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


    @When("I update the Nationality to American")
    public void iUpdateTheNationalityToAmerican() {

        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        System.out.println("Nationality before update: " + "\"" + mi.getNationality().getText() + "\"");

        mi.getNationality().click();

        actions.sendKeys("d").sendKeys("d").sendKeys("d").sendKeys(Keys.ENTER).build().perform();

    }

    @Then("The updated Nationality should be successfully saved and displayed")
    public void theUpdatedNationalityShouldBeSuccessfullySavedAndDisplayed(){

        mi.wait.until(ExpectedConditions.textToBe(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[1]"),"Dutch"));

        Assert.assertEquals(mi.getNationality().getText(),"Dutch");
        System.out.println("Updated Nationality: " + "\"" + mi.getNationality().getText() + "\"");

        DriverClass.quitDriver();

    }

    @When("I update the Marital Status to Single")
    public void iUpdateTheMaritalStatusToSingle() {
        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        System.out.println("Marital Status before update: " + "\"" + mi.getMaritalStatus().getText() + "\"");
        mi.getMaritalStatus().click();

        actions.sendKeys("s").sendKeys(Keys.ENTER).build().perform();
    }

    @Then("The updated Marital Status should be successfully saved and displayed")
    public void theUpdatedMaritalStatusShouldBeSuccessfullySavedAndDisplayed() {
        mi.wait.until(ExpectedConditions.textToBe(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active')])[2]"),"Single"));

        Assert.assertEquals(mi.getMaritalStatus().getText(),"Single");
        System.out.println("Updated Marital Status: " + "\"" + mi.getMaritalStatus().getText() + "\"");

        DriverClass.quitDriver();
    }
}
