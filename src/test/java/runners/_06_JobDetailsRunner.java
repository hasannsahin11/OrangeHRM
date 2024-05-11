package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\_06_JobDetails.feature"},
        glue = {"stepDefinitions"}
)
public class _06_JobDetailsRunner extends AbstractTestNGCucumberTests {
}
