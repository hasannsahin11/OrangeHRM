package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.MyInfo;
import utils.DriverClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class _05_UploadProfilePictureSteps {

    DialogContent dc = new DialogContent();
    MyInfo mi = new MyInfo();

    @Given("I'm on the My Info page")
    public void imOnTheMyInfoPage() {
        mi.clickMethod(mi.getMyInfoBtn());
    }

    @When("I click on the photograph displayed at the top left corner of the page")
    public void i_click_on_the_photograph_displayed_at_the_top_left_corner_of_the_page() {

        mi.getProfilePic().click();
    }

    int previousWidth;
    int previousHeight;

    @And("I click on the Choose a File button")
    public void i_click_on_the_choose_a_file_button() {


        previousWidth = Integer.parseInt(mi.getProfilePic().getAttribute("naturalWidth"));
        previousHeight = Integer.parseInt(mi.getProfilePic().getAttribute("naturalHeight"));
        System.out.println("Previous Image's width: " + previousWidth);
        System.out.println("Previous Image's height: " + previousHeight);

        mi.clickMethod(mi.getUploadBtn());

    }
    @And("I select a JPG image file that is less than One MB")
    public void i_select_a_jpg_image_file_that_is_less_than_one_mb() {

        String newPPPath = "\"C:\\Users\\hasan\\OneDrive\\Masaüstü\\mi9.jpg\"";

        try {
            Robot robot = new Robot();

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(newPPPath);
            clipboard.setContents(stringSelection, null);

            robot.delay(2000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(2000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(2000);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    int uploadedWidth;
    int uploadedHeight;
    @Then("the profile picture should be successfully uploaded and displayed")
    public void the_profile_picture_should_be_successfully_uploaded_and_displayed() {

        mi.wait.until(ExpectedConditions.attributeToBe(By.xpath("(//img[@alt='profile picture'])[2]"),"naturalWidth", "1153"));

        uploadedHeight = Integer.parseInt(mi.getProfilePic().getAttribute("naturalWidth"));
        uploadedHeight = Integer.parseInt(mi.getProfilePic().getAttribute("naturalHeight"));
        System.out.println("Uploaded Image's width: " + mi.getProfilePic().getAttribute("naturalWidth"));
        System.out.println("Uploaded Image's height: " + mi.getProfilePic().getAttribute("naturalHeight"));

        Assert.assertFalse(previousHeight==uploadedHeight);
        Assert.assertFalse(previousWidth == uploadedWidth);

        DriverClass.quitDriver();

    }

}
