import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/redirect_accept.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    public double funcCalc(double x) {
        return log(abs(12 * sin(x)));
    }
    @Test
    public void switchTest() throws InterruptedException {
        WebElement linkButton = driver.findElement((By.tagName("button")));
        linkButton.click();
        System.out.println(driver.getWindowHandles()); // возвращает все вкладки [0,1] [43AC1B58FF28467D02525B4B4F142923, FE6DE232A979E43784D570038DAFF720]
        System.out.println(driver.getWindowHandle()); //возвращает открытую/текущую вкладку
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement x = driver.findElement(By.id("input_value"));
        System.out.println(x.getText());
        double xValue = parseDouble(x.getText());// преобразование строки в число дабл
        double result = funcCalc(xValue);
        System.out.println(result);
        WebElement answerInputField =
                driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));//(String.valueOf(result)) -  преобразовываем double в
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }


}



