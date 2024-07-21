package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke or @@Regression",
        features = {"C:\\Users\\hasan\\IdeaProjects\\OrangeHRM\\src\\test\\java\\features"},
        glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class _04_ParallelTestRunner {


}
