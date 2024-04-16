package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\_04_UpdateFirstName.feature"},
        glue = {"stepDefinitions"}
)
public class _04_UpdateFirstNameRunner extends AbstractTestNGCucumberTests {
}
