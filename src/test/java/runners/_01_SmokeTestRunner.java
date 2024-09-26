package runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "@Smoke",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"},
//        plugin = {"html:target/site/cucumber-pretty.html"}
//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
        plugin = {"json:target/cucumber/cucumber.json"}
)

public class _01_SmokeTestRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "H.Sahin");
        ExtentService.getInstance().setSystemInfo("Application Name", "Orange HRM");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Additional line", "Additional Info");
    }
}
