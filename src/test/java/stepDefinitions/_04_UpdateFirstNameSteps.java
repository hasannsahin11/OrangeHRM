package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.MyInfo;
import utils.DriverClass;

public class _04_UpdateFirstNameSteps {
    MyInfo mi = new MyInfo();

    Actions actions = new Actions(DriverClass.getDriver());

    @When("I change the First Name field to {string}")
    public void i_change_the_field_to(String firstName) throws InterruptedException {
//        mi.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
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
}
