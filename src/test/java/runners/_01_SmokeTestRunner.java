package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty.html"}
)

public class _01_SmokeTestRunner extends AbstractTestNGCucumberTests {

}
