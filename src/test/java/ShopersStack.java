import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopersStack {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://shoppersstack.com/");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
        loginButton.click();

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));//driver.findElement(By.id("Email"));
        emailField.isDisplayed(); //- метод isDisplayed вернет true or false
        assertTrue(emailField.isDisplayed());//assertTrue проверяет соответствие True

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Password"))); //driver.findElement(By.id("Password"));
        passwordField.isDisplayed(); //- метод isDisplayed вернет true or false
        assertTrue(passwordField.isDisplayed());//assertTrue проверяет соответствие True

        //5. Follow the link "Forgot password?"
        WebElement forgotPassword = driver.findElement(By.cssSelector("[name='Forgot Password?']"));
        forgotPassword.click();

        //6. Enter "forgotpassword@gmail.com" to the email input field
        WebElement enterEmail = driver.findElement(By.id("email"));
        enterEmail.sendKeys("forgotpassword@gmail.com");// заполнить Field email

        //7. Click on "Proceed" button
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type=\"button\"])[1]"));
        submitButton.click();
        //8. Verify the error message "User email forgotpassword@gmail.com, does not exist" is displayed
        WebElement assertIsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[role = 'alert']")));
        assertEquals("User email forgotpassword@gmail.com, does not exist", assertIsDisplayed.getText());
        //9. Check that URL contains "/forgot"
        assertTrue(driver.getCurrentUrl().contains("/forgot"));
    }

}
