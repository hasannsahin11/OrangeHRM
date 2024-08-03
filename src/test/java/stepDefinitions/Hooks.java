package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverClass;

public class Hooks {
    @Before // This method runs before every scenario
    public void beforeScenario() {
        System.out.println("Scenario has started!");
    }

    @After // This one runs after all the scenarios
    public void afterScenario(Scenario scenario) {

        if(scenario.isFailed()){
            final byte[] byteImage = ((TakesScreenshot) DriverClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", "screenShot name");
        }

        System.out.println("Scenario has ended!");
    }
}
