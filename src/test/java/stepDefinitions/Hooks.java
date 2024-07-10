package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before // This method runs before every scenario
    public void beforeScenario() {
        System.out.println("Scenario has started!");

    }

    @After // This one runs after all the scenarios
    public void afterScenario(Scenario scenario) {
        System.out.println("Scenario has ended!");
    }
}
