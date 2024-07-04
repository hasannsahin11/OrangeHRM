package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.Qualifications;
import utils.DriverClass;

import java.util.List;

public class MI_06_QualificationsSteps {

    Qualifications q = new Qualifications();
    DialogContent dc = new DialogContent();

    Actions actions = new Actions(DriverClass.getDriver());

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


    @When("I click on the Add Work Experience button")
    public void i_click_on_the_add_work_experience_button() {
        q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
        q.getWorkExpAddBtn().click();
    }

    @And("I fill in the Company field with {string}")
    public void i_fill_in_the_company_field_with(String companyName) {

        q.getCompanyField().click();
        q.getCompanyField().sendKeys(companyName);

    }

    @And("I fill in the Job Title field with {string}")
    public void i_fill_in_the_job_title_field_with(String jobTitle) {

        q.sendKeysMethod(q.getJobTitleField(), jobTitle);

    }

    @And("I select Start Date as {string}")
    public void i_select_start_date_as(String startDate) {

        q.getFromDate().sendKeys(startDate);

    }

    @And("I select End Date as {string}")
    public void i_select_end_date_as(String endDate) {

        q.getEndDate().sendKeys(endDate);

    }

    @And("I fill in the Comment field with {string}")
    public void i_fill_in_the_comment_field_with(String comment) {

        q.getCommentField().sendKeys(comment);

    }

    @And("I click on the Save Work Experience button")
    public void i_click_on_the_save_work_experience_button() {

//        q.getSaveQualificationButton().click();
        dc.getSaveBtn().click();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.getSuccessMessage()));
        System.out.println(dc.getSuccessMessage().getText());

    }

    @Then("I should see the new Work Experience listed with {string} and {string}")
    public void i_should_see_the_new_work_experience_listed_with_and(String listedCompanyName, String listedJobTitle) {

        System.out.println("q.getListedWorkExperienceCompanyName().getText() = " + q.getListedWorkExperienceCompanyName().getText());
        System.out.println("q.getListedWorkExperienceJobTitle().getText() = " + q.getListedWorkExperienceJobTitle().getText());

        Assert.assertEquals(q.getListedWorkExperienceCompanyName().getText(), listedCompanyName);
        Assert.assertEquals(q.getListedWorkExperienceJobTitle().getText(), listedJobTitle);

        DriverClass.quitDriver();
    }

    @And("I click on the Edit icon of the existing Work Experience")
    public void iClickOnTheEditIconOfTheExistingWorkExperience() {

        q.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".employee-image")));
//        q.wait.until((ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[5]"))));

       q.getEditExistingWorkExpBtn().click();
    }

    @And("I modify the Company name with {string} and the Job Title field with {string}")
    public void iModifyTheCompanyNameWithAndTheJobTitleFieldWith(String companyName, String jobTitle) {

        q.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@data-v-1f99f73c])[2]")));
        q.getCompanyField().click();

        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();

        q.getCompanyField().sendKeys(companyName);

        actions.sendKeys(Keys.TAB).sendKeys(Keys.BACK_SPACE).build().perform();

        q.getJobTitleField().sendKeys(jobTitle);

    }

    @Then("I should see the updated Work Experience listed with {string} and {string}")
    public void iShouldSeeTheUpdatedWorkExperienceListedWithAnd(String listedCompanyNameAfterUpdate, String listedJobTitleAfterUpdate) {

        System.out.println("q.getListedWorkExperienceCompanyNameAfterUpdate().getText() = " + q.getListedWorkExperienceCompanyNameAfterUpdate().getText());
        System.out.println("q.getListedWorkExperienceJobTitleAfterUpdate().getText() = " + q.getListedWorkExperienceJobTitleAfterUpdate().getText());

        Assert.assertEquals(q.getListedWorkExperienceCompanyNameAfterUpdate().getText(), listedCompanyNameAfterUpdate);
        Assert.assertEquals(q.getListedWorkExperienceJobTitleAfterUpdate().getText(), listedJobTitleAfterUpdate);

        DriverClass.quitDriver();

    }

    @When("I click on the Delete icon of the created Work Experience")
    public void iClickOnTheDeleteIconOfTheCreatedWorkExperience() {

    }

    @Then("The Work Experience should be successfully deleted and removed from the list")
    public void theWorkExperienceShouldBeSuccessfullyDeletedAndRemovedFromTheList() {
    }
}
