import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrames {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkParentHeader(){
        //switch to parent frame
        driver.switchTo().frame("frame1");
        //check that "Parent frame" text is displayed
        WebElement parentHeader = driver.findElement(By.tagName("body"));
        assertEquals("Parent frame", parentHeader.getText());
        //check that "Child Iframe" text is displayed
        WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrame);
        WebElement childHeader = driver.findElement(By.tagName("p"));
        assertEquals("Child Iframe", childHeader.getText());
    }

}
