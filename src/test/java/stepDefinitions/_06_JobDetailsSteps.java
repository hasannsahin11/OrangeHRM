package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.JobDetails;
import pages.MyInfo;

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
    public void andFieldsShouldBeDisplayedAndDisabledForModification(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {


    }
}
