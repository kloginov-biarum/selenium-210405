import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frame {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void checkFirstFrameHeader(){
        driver.switchTo().frame("frame1");
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());
    }


    //Check that second header in small window has text "This is a sample page"
    //1 - отдельным тестом
    //2 - в одном тесте с checkFirstFrameHeader()

    @Test
    public void checkSecondFrameHeader(){
        driver.switchTo().frame("frame2");
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());
    }

    @Test
    public void checkSecondFrameHeaderInOneTest(){
        driver.switchTo().frame("frame1");
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement header2 = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header2.getText());
    }
    @Test
    public void tryToFindHeaderWithoutSwitching(){
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());
    }
}
