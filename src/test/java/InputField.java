import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputField {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/huge_form.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void numbersInputField() throws InterruptedException {
        WebElement numbersInput = driver.findElement(By.cssSelector("[type='number']"));
        numbersInput.sendKeys("1000");
        numbersInput.clear();
        numbersInput.sendKeys("999");
    }


}
