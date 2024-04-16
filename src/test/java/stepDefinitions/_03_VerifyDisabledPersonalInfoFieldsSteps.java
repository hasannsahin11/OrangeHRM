package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.MyInfo;
import utils.DriverClass;

import java.util.List;

public class _03_VerifyDisabledPersonalInfoFieldsSteps {

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
}
