package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Qualifications;
import utils.DriverClass;

public class MI_06_QualificationsSteps {

    Qualifications q = new Qualifications();

    @Given("I navigate to the Qualifications Section")
    public void i_navigate_to_the_qualifications_section() {
        q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
        q.getQualificationsBtn().click();
    }

    @When("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DriverClass.getDriver();


        q.wait.until(ExpectedConditions.visibilityOf(q.getWorkExperience()));

        if (q.getWorkExperience().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getEducation()));
        if (q.getEducation().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getSkills()));
        if (q.getSkills().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getLanguages()));
        if (q.getLanguages().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 200);

        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getLicense()));
        if (q.getLicense().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getAttachments()));
        if (q.getAttachments().isDisplayed()) {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        }

//            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
//            Thread.sleep(1500);
//            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
//            Thread.sleep(1500);
//            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
//            Thread.sleep(3000);
//            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
//            Thread.sleep(3000);
//            js.executeScript("window.scrollBy(0, arguments[0]);", 200);
        }

        @Then("I should see the following Qualification headers:")
        public void i_should_see_the_following_qualification_headers (DataTable dataTable){

        }

        public void scroll () {

        }

    }
