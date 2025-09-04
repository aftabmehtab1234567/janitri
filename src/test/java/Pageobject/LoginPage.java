package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    By txtUserId = By.xpath("//input[contains(@name,'email')]");
    By txtPassword = By.xpath("//input[contains(@name,'password')]");
    By btnLogin = By.xpath("//button[contains(@class,'login-button')]");
    By eyeToggle = By.xpath("//img[contains(@alt,'Password Visible') or contains(@alt,'Password Not Visible')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userid) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserId));
        userField.clear();
        userField.sendKeys(userid);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        loginButton.click();
    }

    public void toggleEyeIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement eyeIcon = wait.until(ExpectedConditions.elementToBeClickable(eyeToggle));
        eyeIcon.click();
    }

    public boolean isPasswordMasked() {
        WebElement passwordField = driver.findElement(txtPassword);
        String type = passwordField.getAttribute("type");
        return type.equals("password");
    }

    public boolean isPasswordVisible() {
        WebElement passwordField = driver.findElement(txtPassword);
        String type = passwordField.getAttribute("type");
        return type.equals("text");
    }
}
