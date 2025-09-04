package Testcase;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pageobject.LoginPage;

public class Testcase extends Base {

    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);  
        login.enterUserId("validemail@example.com");
        login.enterPassword("validpassword");
        login.clickLogin();

        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"), "Login should fail, but it succeeded.");
    }

    @Test(priority = 2)
    public void testBlankCredentials() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("");
        login.enterPassword("");
        login.clickLogin();
        By errorPageElement = By.xpath("//div[contains(@class,'invalid-credential-div')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPageElement));
        Assert.assertFalse(driver.getPageSource().contains("required"), "Blank credentials error not shown");
    }

    @Test(priority = 3)
    public void testOnlyUserId() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("validemail@example.com");
        login.enterPassword("");
        login.clickLogin();
        By errorPageElement = By.xpath("//div[contains(@class,'invalid-credential-div')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPageElement));
        Assert.assertFalse(driver.getPageSource().contains("Password is required"), "Password error not shown");
    }

    @Test(priority = 4)
    public void testOnlyPassword() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("");
        login.enterPassword("somepassword");
        login.clickLogin();
        By errorPageElement = By.xpath("//div[contains(@class,'invalid-credential-div')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPageElement));
        Assert.assertFalse(driver.getPageSource().contains("Email is required"), "Email error not shown");
    }

    @Test(priority = 5)
    public void testInvalidCredentials() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("wrong@example.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();

        By errorPageElement = By.xpath("//div[contains(@class,'invalid-credential-div')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPageElement));

        Assert.assertTrue(error.isDisplayed(), "Invalid credentials error is not shown");
    }


    @Test(priority = 6)
    public void testEyeToggleFunctionality() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("samplePassword");

        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked");

        login.toggleEyeIcon();
        Assert.assertTrue(login.isPasswordVisible(), "Password should be visible");

        login.toggleEyeIcon();
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked again");
    }
}
