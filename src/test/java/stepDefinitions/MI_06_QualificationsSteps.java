package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Qualifications;
import utils.DriverClass;
import java.util.List;

public class MI_06_QualificationsSteps {

    Qualifications q = new Qualifications();

    @Given("I navigate to the Qualifications Section")
    public void i_navigate_to_the_qualifications_section() {
        q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
        q.getQualificationsBtn().click();
    }

    @When("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() throws InterruptedException {

        q.wait.until(ExpectedConditions.urlContains("viewQualifications"));
        q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
        JavascriptExecutor js = (JavascriptExecutor) DriverClass.getDriver();


        q.wait.until(ExpectedConditions.visibilityOf(q.getWorkExperience()));
        if (q.getWorkExperience().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 150);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getEducation()));
        if (q.getEducation().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 150);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getSkills()));
        if (q.getSkills().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 150);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getLanguages()));
        if (q.getLanguages().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 150);

        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getLicense()));
        if (q.getLicense().isDisplayed()) {
            js.executeScript("window.scrollBy(0, arguments[0]);", 150);
        }

        q.wait.until(ExpectedConditions.visibilityOf(q.getAttachments()));
        if (q.getAttachments().isDisplayed()) {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        }
    }

    @Then("I should see the following Qualification headers:")
    public void i_should_see_the_following_qualification_headers(DataTable dataTable) {
        List<String> headers = dataTable.asList();

        for (String qHeaders : headers) {
            Assert.assertTrue(getHeader(qHeaders).isDisplayed());
            System.out.println("Displayed Qualifications Header: " + getHeader(qHeaders).getText());
        }

        DriverClass.quitDriver();

    }

    public WebElement getHeader(String headerName) {
        WebElement header = DriverClass.getDriver().findElement(By.xpath("//h6[contains(.,'" + headerName + "')]"));
        return header;
    }

//     q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
//        q.getWorkExpAddBtn().click();
@When("I click on the Add Work Experience button")
public void i_click_on_the_add_work_experience_button() {

}
    @And("I fill in the Company field with {string}")
    public void i_fill_in_the_company_field_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I fill in the Job Title field with {string}")
    public void i_fill_in_the_job_title_field_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I select Start Date as {string}")
    public void i_select_start_date_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I select End Date as {string}")
    public void i_select_end_date_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I fill in the Comment field with {string}")
    public void i_fill_in_the_comment_field_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I click on the Save Work Experience button")
    public void i_click_on_the_save_work_experience_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should see the new Work Experience listed with {string} and {string}")
    public void i_should_see_the_new_work_experience_listed_with_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
