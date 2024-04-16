package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\_01_ESSUserAccountCreation.feature"},
        glue = {"stepDefinitions"}
)
public class _01_ESSUserAccountCreationRunner extends AbstractTestNGCucumberTests {
}
