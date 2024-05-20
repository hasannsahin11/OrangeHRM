package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features\\myInfo\\_07_EmergencyContacts.feature"},
        glue = {"stepDefinitions"}
)
public class _07_EmergencyContactsRunner extends AbstractTestNGCucumberTests {
}
