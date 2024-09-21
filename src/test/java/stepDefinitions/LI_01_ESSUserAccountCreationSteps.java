package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.AdminPanel;
import pages.DialogContent;
import utils.DriverClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

public class LI_01_ESSUserAccountCreationSteps {
    DialogContent dc = new DialogContent();
    AdminPanel ap = new AdminPanel();

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {

        DriverClass.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ap.wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        System.out.println("On the orangeHRM login page");

    }

    @When("I enter the Admin credentials")
    public void i_enter_the_admin_credentials() {


        ap.wait.until(ExpectedConditions.visibilityOf(ap.getUserName()));
        ap.getUserName().sendKeys("Admin");
        ap.getPassword().sendKeys("admin123");

        System.out.println("Entered admin credentials");

    }

    @And("I click the Login button")
    public void i_click_the_login_button() {

        ap.clickMethod(ap.getLoginBtn());
        System.out.println("Clicked on login");
        ap.wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    @And("I navigate to the Admin panel")
    public void i_navigate_to_the_admin_panel() {

        ap.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")));
        ap.getAdminBtn().click();
        System.out.println("Navigated to the admin panel");

    }

    @And("I click the Add button")
    public void i_click_the_add_button() {


        ap.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--medium') and contains(@class, 'oxd-button--secondary')])[2]")));
        ap.getAddBtn().click();

        System.out.println("Clicked on the Add button");
        ap.wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

    }

    @When("I select the necessary options for User role and Status")
    public void i_select_the_necessary_options_for_user_role_and_status() throws AWTException {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        ap.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-select-text-input']")));
//        ap.getUserRoleSelect().click();

        Actions actions = new Actions(DriverClass.getDriver());
        actions.moveToElement(ap.getUserRoleSelect()).click().build().perform();


        Robot robot = new Robot();
        robot.delay(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        ap.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-select-text-input'])[2]")));
//        ap.getStatusSelect().click();

        actions.moveToElement(ap.getStatusSelect()).click().build().perform();


        robot.delay(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Selected user role and status");

    }

    @And("I fill out the necessary fields with:")
    public void i_fill_out_the_necessary_fields_with(List<Map<String, String>> dataTable) throws AWTException {

        Robot robot = new Robot();

        for (Map<String, String> row : dataTable) {
            String field = row.get("Field");
            String value = row.get("Value");

            switch (field) {
                case "Employee Name":
                    ap.clickMethod(ap.getEmployeeName());
                    ap.sendKeysMethod(ap.getEmployeeName(), row.get("Value"));

                    robot.delay(2000);

                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    break;

                case "Username":
                    robot.delay(2000);
                    ap.sendKeysMethod(ap.getEssUserName(), row.get("Value"));
                    break;

                case "Password":
                    robot.delay(2000);

                    ap.sendKeysMethod(ap.getEssPassword(), row.get("Value"));
                    break;

                case "Confirm Password":
                    robot.delay(2000);

                    ap.sendKeysMethod(ap.getEssConfPassword(), row.get("Value"));
                    break;

                default:
                    System.out.println("Unknown field: " + field);
                    break;
            }
        }

        System.out.println("Filled out all the necessary fields");

    }

    @And("I click on the Save button")
    public void i_click_on_the_save_button() {

        dc.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")));
        dc.getSaveBtn().click();
        System.out.println("Clicked on Save button");


//        dc.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@data-v-7b563373 and @data-v-35c8fe09 and contains(@class, 'oxd-text') and contains(@class, 'oxd-text--toast-message') and contains(@class, 'oxd-toast-content-text')]")));
//        System.out.println(dc.getSuccessMessage().getText());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(DriverClass.getDriver().findElement(By.xpath("//p[@data-v-7b563373 and @data-v-35c8fe09 and contains(@class, 'oxd-text') and contains(@class, 'oxd-text--toast-message') and contains(@class, 'oxd-toast-content-text')]")).getText());

    }

    @Then("An ESS user should be successfully created")
    public void an_ess_user_should_be_successfully_created() {

//        dc.waitUntilVisible(dc.getSuccessMessage());

//        System.out.println(dc.getSuccessMessage().getText());
//        Assert.assertTrue(dc.getSuccessMessage().isDisplayed());

        Assert.assertTrue(DriverClass.getDriver().findElement(By.xpath("//p[@data-v-7b563373 and @data-v-35c8fe09 and contains(@class, 'oxd-text') and contains(@class, 'oxd-text--toast-message') and contains(@class, 'oxd-toast-content-text')]")).isDisplayed());
        System.out.println("An ESS account has been successfully created!");

        DriverClass.quitDriver();

    }

}
