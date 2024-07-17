package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"}
)

public class _01_SmokeTestRunner extends AbstractTestNGCucumberTests {

}
