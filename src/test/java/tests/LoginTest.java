package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverClass;


public class LoginTest extends DriverClass {

    /**
     * 1- Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
     * 2 - Enter ESS credentials
     * 3- Click Login
     * Verify Dashboard page displayed.
     */

    // <input data-v-1f99f73c="" class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="">
    @Test
    public void login() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));

        username.sendKeys("JButler6");

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));

        password.sendKeys("JButler6");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        loginBtn.click();

        WebElement dashboard = driver.findElement(By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(),"Dashboard");

    }

}
