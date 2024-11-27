import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsDemoQA {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://shoppersstack.com");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void openLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginBtn")));
        loginButton.click();
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        assertTrue(emailInput.isDisplayed());
    }
    @Test
    public void firstAlert(){
        WebElement firstClickMeButton = driver.findElement(By.id("alertButton"));
        firstClickMeButton.click();
        //Check that alert has text "You clicked a button"
        Alert alert = driver.switchTo().alert();
        assertEquals("You clicked a button", alert.getText());
    }

    @Test
    public void secondAlert(){
    WebElement secondClickMeButton = driver.findElement(By.id("timerAlertButton"));
    secondClickMeButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    assertEquals("This alert appeared after 5 seconds", alert.getText());
    }


    //1. Open page https://shoppersstack.com/
    //2. Click on "Login" button
    //3. Check that email input is displayed
    //4. Check that password input is displayed
    //5. Follow the link "Forgot password?"
    //6. Enter "forgotpassword@gmail.com" to the email input field
    //7. Click on "Proceed" button
    //8. Verify the error message "User email forgotpassword@gmail.com, does not exist" is displayed



}
