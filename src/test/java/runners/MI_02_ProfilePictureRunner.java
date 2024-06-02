package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\myInfo\\MI_02_ProfilePicture.feature"},
        glue = {"stepDefinitions"}
)

public class MI_02_ProfilePictureRunner extends AbstractTestNGCucumberTests {
}
