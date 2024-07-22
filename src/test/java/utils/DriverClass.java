package utils;

import org.openqa.selenium.WebDriver;


public class DriverClass {


    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<String> threadDriverName = new ThreadLocal<>();


    public static void setThreadDriverName(String browserName) {

    }

}

// Old Driver

//    public static WebDriver driver;
//    @BeforeClass
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        }
//        return driver;
//    }
//
//    @AfterClass
//    public static void quitDriver() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//        driver = null;
//    }