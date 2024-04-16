package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\_03_VerifyDisabledPersonalInfoFields.feature"},
        glue = {"stepDefinitions"}
)

public class _03_VerifyDisabledPersonalInfoFieldsRunner extends AbstractTestNGCucumberTests {
}
