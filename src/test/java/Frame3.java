import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frame3 {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTextInFrame(){
    //Check that text in frame is "Your content goes here."
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInFrame = driver.findElement(By.id("tinymce"));
        assertEquals("Your content goes here.", textInFrame.getText());
    }
}
