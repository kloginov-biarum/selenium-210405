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

import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Dropdown {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/selects1.html");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));
        int valueNum1 = parseInt(num1.getText());
        int valueNum2 = parseInt(num2.getText());
        int sum = valueNum1 + valueNum2;
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement answerOption = driver.findElement(By.cssSelector("[value='" + sum + "']"));
        answerOption.click();
        //click on submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        //Check that alert contains text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
