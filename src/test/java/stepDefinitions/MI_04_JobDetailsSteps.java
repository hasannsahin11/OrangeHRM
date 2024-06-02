package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.JobDetails;
import pages.MyInfo;
import utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class MI_04_JobDetailsSteps {

    MyInfo mi = new MyInfo();
    JobDetails jd = new JobDetails();

    @When("I navigate to Job Details section")
    public void iNavigateToJobDetailsSection() {
        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        jd.getJobBtn().click();
        jd.wait.until(ExpectedConditions.urlContains("viewJobDetails"));

    }

    @Then("{string}, {string}, {string}, {string}, {string}, {string}, and {string} fields should be displayed and disabled for modification.")
    public void andFieldsShouldBeDisplayedAndDisabledForModification(String joinedDate, String jobTitle, String jobSpecification, String jobCategory, String subUnit, String location, String employmentStatus) {
        List<String> fieldValues = new ArrayList<>();
        fieldValues.add("Customer Success Manager");
        fieldValues.add("Professionals");
        fieldValues.add("Technical Support");
        fieldValues.add("New York Sales Office");
        fieldValues.add("Full-Time Permanent");

        jd.wait.until(ExpectedConditions.textToBePresentInElement(jd.getJobTitleField(), fieldValues.get(0)));

        System.out.println(jd.getJoinedDateCalender().getAttribute("class"));
        Assert.assertTrue(jd.getJoinedDateCalender().getAttribute("class").contains("disabled"));
        System.out.println("Value in the disabled " + joinedDate + " field: " + jd.getJoinedDate().getAttribute("value"));

        Assert.assertTrue(jd.getJobSpecificationTitle().getAttribute("class").contains("disabled"));
        System.out.println("Value in the disabled " + jobSpecification + " field: " + jd.getJobSpecificationValue().getText());

        for (int i = 1; i <= 5; i++) {
            Assert.assertTrue(getField(i).getAttribute("class").contains("disabled"));
            Assert.assertEquals(getField(i).getText(), fieldValues.get(i - 1));
            System.out.println("Value in the disabled field: " + getField(i).getText());
        }

        DriverClass.quitDriver();

    }

    private WebElement getField(int index) {

        WebElement element;
        element = DriverClass.getDriver().findElement(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active') and contains(@class,'oxd-select-text--disabled')])[" + index + "]"));
        return element;
    }

    @And("I toggle the {string} switch to turn it on")
    public void iToggleTheSwitchToTurnItOn(String arg0) throws InterruptedException {
        jd.wait.until(ExpectedConditions.attributeToBe(By.cssSelector("input[type='checkbox']"), "type", "checkbox"));
        jd.getContractDetailsSwitchBtn().click();
    }


    @Then("the following fields should be visible but disabled")
    public void theFollowingFieldsShouldBeVisibleButDisabled(DataTable table) {

        List<String> disabledFields = table.asList(String.class);

        for (String fields : disabledFields) {


            switch (fields) {
                case "Contract Start Date":

                    Assert.assertTrue(jd.getContractStartDate().isDisplayed());
                    Assert.assertFalse(jd.getContractStartDate().isEnabled());
                    System.out.println(fields + " field is Disabled.");

                    break;

                case "Contract End Date":

                    Assert.assertTrue(jd.getContractEndDate().isDisplayed());
                    Assert.assertFalse(jd.getContractEndDate().isEnabled());
                    System.out.println(fields + " field is Disabled.");

                    break;


                case "Contract Details":

                    Assert.assertTrue(jd.getContractDetails().isDisplayed());
                    Assert.assertTrue(jd.getContractDetails().getAttribute("class").contains("disabled"));
                    System.out.println(fields + " field is Disabled.");

                    break;
            }
        }

        DriverClass.quitDriver();

    }

    String switchColorAfterItsOn;
    String switchColorAfterItsOff;

    @And("I refresh the page")
    public void iRefreshThePage() {

        jd.wait.until(ExpectedConditions.textToBe(By.cssSelector(".oxd-file-input-div"), "No file selected"));

        System.out.println("Background Color of the Switch after it's ON: " + DriverClass.getDriver().findElement(By.cssSelector("span.oxd-switch-input")).getCssValue("background-color"));
        switchColorAfterItsOn = DriverClass.getDriver().findElement(By.cssSelector("span.oxd-switch-input")).getCssValue("background-color");

        DriverClass.getDriver().navigate().refresh();

    }

    @Then("the Include Employment Contract Details switch should be turned off")
    public void theIncludeEmploymentContractDetailsSwitchShouldBeTurnedOff() {

        jd.wait.until(ExpectedConditions.attributeToBe(By.cssSelector("input[type='checkbox']"), "type", "checkbox"));

        System.out.println("Background Color of the Switch after it's OFF: " + DriverClass.getDriver().findElement(By.cssSelector("span.oxd-switch-input")).getCssValue("background-color"));
        switchColorAfterItsOff = DriverClass.getDriver().findElement(By.cssSelector("span.oxd-switch-input")).getCssValue("background-color");

        Assert.assertFalse(switchColorAfterItsOn.equalsIgnoreCase(switchColorAfterItsOff));

        DriverClass.quitDriver();

    }
}
