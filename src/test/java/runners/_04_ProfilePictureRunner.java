package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\myInfo\\_04_ProfilePicture.feature"},
        glue = {"stepDefinitions"}
)

public class _04_ProfilePictureRunner extends AbstractTestNGCucumberTests {
}
