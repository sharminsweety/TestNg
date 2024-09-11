package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BrowserLaunch {

    @BeforeTest
    public void BrowserSetup()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        driver.quit();

    }

}
