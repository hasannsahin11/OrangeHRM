package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\login\\LI_01_ESSUserAccountCreation.feature"},
        glue = {"stepDefinitions"}
)
public class LI_01_ESSUserAccountCreationRunner extends AbstractTestNGCucumberTests {
}
