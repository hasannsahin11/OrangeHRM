package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"},
        dryRun = true
)
public class _03_AllFeaturesRunner extends AbstractTestNGCucumberTests {
}
