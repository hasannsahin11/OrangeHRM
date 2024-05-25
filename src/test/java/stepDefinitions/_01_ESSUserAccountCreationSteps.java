package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.AdminPanel;
import pages.DialogContent;
import utils.DriverClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

public class _01_ESSUserAccountCreationSteps {
    DialogContent dc = new DialogContent();
    AdminPanel ap = new AdminPanel();

    @When("I enter the Admin credentials")
    public void i_enter_the_admin_credentials() {

        ap.getUserName().sendKeys("Admin");
        ap.getPassword().sendKeys("admin123");

    }

    @And("I navigate to the Admin panel")
    public void i_navigate_to_the_admin_panel() {

        ap.clickMethod(ap.getAdminBtn());

    }

    @And("I click the Add button")
    public void i_click_the_add_button() {
        ap.clickMethod(ap.getAddBtn());

    }

    @When("I select the necessary options for User role and Status")
    public void i_select_the_necessary_options_for_user_role_and_status() throws AWTException {

        ap.clickMethod(ap.getUserRoleSelect());


        Robot robot = new Robot();
        robot.delay(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        ap.clickMethod(ap.getStatusSelect());


        robot.delay(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
    }

    @And("I click on the Save button")
    public void i_click_on_the_save_button() {

        dc.waitUntilClickable(dc.getSaveBtn());
        dc.clickMethod(dc.getSaveBtn());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.getSuccessMessage()));
        System.out.println(dc.getSuccessMessage().getText());

    }

    @Then("An ESS user should be successfully created")
    public void an_ess_user_should_be_successfully_created() {

        dc.waitUntilVisible(dc.getSuccessMessage());

//        System.out.println(dc.getSuccessMessage().getText());
        Assert.assertTrue(dc.getSuccessMessage().isDisplayed());

        System.out.println("An ESS account has been successfully created!");

        DriverClass.quitDriver();

    }

}
