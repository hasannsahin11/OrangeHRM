package stepDefinitions;

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

public class _06_JobDetailsSteps {

    MyInfo mi = new MyInfo();
    JobDetails jd = new JobDetails();

    @When("I navigate to Job Details section")
    public void iNavigateToJobDetailsSection() {
        mi.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));

        jd.getJobBtn().click();
        jd.wait.until(ExpectedConditions.urlContains("viewJobDetails"));

    }

    @Then("{string} {string} {string} {string} {string} {string} and {string} fields should be displayed and disabled for modification.")
    public void andFieldsShouldBeDisplayedAndDisabledForModification(String joinedDate, String jobTitle, String jobSpecification, String jobCategory, String subUnit, String location, String employmentStatus) {

        List<String> fieldValues = new ArrayList<>();
        fieldValues.add("Customer Success Manager");
        fieldValues.add("Professionals");
        fieldValues.add("Technical Support");
        fieldValues.add("New York Sales Office");
        fieldValues.add("Full-Time Permanent");

        jd.wait.until(ExpectedConditions.textToBePresentInElement(jd.getJobTitleField(), fieldValues.get(0)));

        for (int i = 1; i <= 5; i++) {
            System.out.println(getField(i).getText());
            Assert.assertTrue(getField(i).getAttribute("class").contains("disabled"));
            Assert.assertEquals(getField(i).getText(), fieldValues.get(i - 1));
        }
    }

    private WebElement getField(int index) {

        WebElement element;
        element = DriverClass.getDriver().findElement(By.xpath("(//div[contains(@class,'oxd-select-text') and contains(@class,'oxd-select-text--active') and contains(@class,'oxd-select-text--disabled')])[" + index + "]"));
        return element;
    }

}
