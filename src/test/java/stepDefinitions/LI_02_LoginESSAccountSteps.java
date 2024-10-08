package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverClass;

public class LI_02_LoginESSAccountSteps {

    LoginPage lp = new LoginPage();

    @When("I enter the ESS credentials")
    public void i_enter_the_ess_credentials() {

        lp.sendKeysMethod(lp.getUserName(), "SShaheen11");
        lp.sendKeysMethod(lp.getPassword(), "SShaheen11");
    }


    @Then("I should see the Dashboard page displayed")
    public void i_should_see_the_dashboard_page_displayed() {
        System.out.println("Header of this current page: " + lp.getDashboard().getText());
        Assert.assertTrue(lp.getDashboard().getText().toLowerCase().contains("dashboard"));
        DriverClass.quitDriver();
    }


    @When("I enter the username {string}")
    public void i_enter_the_username(String username){
        lp.sendKeysMethod(lp.getUserName(), username);
    }

    @When("I enter the password {string}")
    public void i_enter_the_password(String password) {
        lp.sendKeysMethod(lp.getPassword(), password);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        System.out.println("Here is the displayed message:"+ lp.getInvalidCredentialsMsg().getText());
        Assert.assertEquals(lp.getInvalidCredentialsMsg().getText(),"Invalid credentials");
        DriverClass.quitDriver();
    }
}
