package Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Base {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-dash.janitri.in/");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
