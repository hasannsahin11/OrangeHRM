package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before // This method runs before every scenario
    public void beforeScenario() {
        System.out.println("Scenario has started!");
    }

    @After // This one runs after all the scenarios
    public void afterScenario(Scenario scenario) {

        if(scenario.isFailed()){
            final byte[] byteImage = ((TakesScreenshot) DriverClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());

//             Save the screenshot on our computer
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverClass.getDriver();
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            LocalDateTime timeOfError = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss");

            try {
                FileUtils.copyFile(file,new File("src/test/java/Screenshots/screenshot"+timeOfError.format(formatter)+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Scenario has ended!");
    }
}
