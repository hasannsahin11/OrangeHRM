package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\login\\LI_02_LoginESSAccount.feature"},
        glue = {"stepDefinitions"}
)
public class LI_02_LoginESSAccountRunner extends AbstractTestNGCucumberTests {
}
