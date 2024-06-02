package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\myInfo\\MI_03_ContactDetails.feature"},
        glue = {"stepDefinitions"}
)
public class MI_03_ContactDetailsRunner extends AbstractTestNGCucumberTests {
}
