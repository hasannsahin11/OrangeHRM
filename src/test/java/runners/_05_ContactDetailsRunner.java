package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\_05_ContactDetails.feature"},
        glue = {"stepDefinitions"}
)
public class _05_ContactDetailsRunner extends AbstractTestNGCucumberTests {
}
