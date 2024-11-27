import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrames2 {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-x64-2/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void checkAllTexts() throws InterruptedException {
        //Check that "LEFT", "MIDDLE", "RIGHT", "BOTTOM" texts are present
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        WebElement frameLeftHeader = driver.findElement(By.tagName("body"));
        assertEquals("LEFT", frameLeftHeader.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement frameMiddleHeader = driver.findElement(By.id("content"));
        assertEquals("MIDDLE", frameMiddleHeader.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement frameRightHeader = driver.findElement(By.cssSelector("body"));
        assertEquals("RIGHT", frameRightHeader.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        WebElement frameBottomHeader = driver.findElement(By.cssSelector("body"));
        assertEquals("BOTTOM", frameBottomHeader.getText());
    }

}
