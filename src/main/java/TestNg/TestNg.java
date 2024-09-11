
package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNg {

    @Test
    public void CheckTitle() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        driver.quit();
    }

    @Test
    public void CheckURL() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/");
        driver.quit();

    }

    @Test
    public void LoginFail() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        //  int count = driver.findElements(By.className("error-button")).size();
        //Assert.assertEquals(count, 1);


        WebElement errorMessage = driver.findElement(By.className("error-button"));

        // Verify that the error message is displayed

        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        driver.quit();
    }

    @Test

    public void LoginPass() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();


        String logoutText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();

        Assert.assertEquals(logoutText,"Logout");

    }

}
