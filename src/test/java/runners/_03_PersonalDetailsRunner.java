package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\myInfo\\_03_PersonalDetails.feature"},
        glue = {"stepDefinitions"}
)

public class _03_PersonalDetailsRunner extends AbstractTestNGCucumberTests {
}
