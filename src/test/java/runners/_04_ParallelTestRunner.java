package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverClass;

@CucumberOptions(
        tags = "@Smoke or @@Regression",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty.html"}
//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class _04_ParallelTestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters(value = "browser")
    public void beforeClass(@Optional("chrome") String browserName) {
        DriverClass.setThreadDriverName(browserName);
    }

}
