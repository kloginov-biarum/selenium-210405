import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalc {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/math.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public double funcCalc(double x){
            return log(abs(12*sin(x)));
    }

    @Test
    public void correctValue() throws InterruptedException {
        WebElement x = driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText());
        double result = funcCalc(xValue);
        System.out.println(result);
        WebElement answerInputField =
                driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        //check checkbox I'm the robot
        //choose Robots rule
        WebElement checkboxRobot = driver.findElement(By.id("robotCheckbox"));
        checkboxRobot.click();
        WebElement radioButtonRobot = driver.findElement(By.id("robotsRule"));
        radioButtonRobot.click();
        //push Submit button
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
